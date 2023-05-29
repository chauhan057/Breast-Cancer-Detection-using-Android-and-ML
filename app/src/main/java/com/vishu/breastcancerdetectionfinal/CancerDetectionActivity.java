package com.vishu.breastcancerdetectionfinal;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;

import android.os.Bundle;
import android.provider.MediaStore;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vishu.breastcancerdetectionfinal.ml.Model2;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class CancerDetectionActivity extends AppCompatActivity {


    TextView result,confidence;
    ImageView imageView;
    Button picture;
    Button loadImage;
    int imageSize=224;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancer_detection);

        result=findViewById(R.id.result);
        confidence=findViewById(R.id.confidence);
        imageView=findViewById(R.id.imageView);
        picture=findViewById(R.id.button);
        loadImage = findViewById(R.id.takeButton);

        loadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,3);
            }
        });


        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //launch camera if we have permission
                if(checkSelfPermission(android.Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(CancerDetectionActivity.this, "Button is clicked", Toast.LENGTH_SHORT).show();
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent,1);
                }else {
                    //request camera permission if don't have it.
                    requestPermissions(new String[]{Manifest.permission.CAMERA},100);
                }
            }
        });
    }





    public void classifyImage(Bitmap image){
        try {
            Model2 model = Model2.newInstance(getApplicationContext());

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4* imageSize* imageSize*3);
            byteBuffer.order(ByteOrder.nativeOrder());

            int [] intValues = new int[imageSize * imageSize];
            image.getPixels(intValues,0,image.getWidth(),0,0,image.getWidth(),image.getHeight());
            int pixel =0;
            for (int i=0;i<imageSize;i++){
                for (int j=0;j<imageSize;j++){

                    int val = intValues[pixel++];//RGB
                    byteBuffer.putFloat(((val>>16)& 0xFF)*(1.f / 255.f));
                    byteBuffer.putFloat(((val>>8)& 0xFF)*(1.f / 255.f));
                    byteBuffer.putFloat((val>>0xFF)*(1.f / 255.f));
                }
            }

            inputFeature0.loadBuffer(byteBuffer);


            // Runs model inference and gets result.
            Model2.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            float[] confidences =outputFeature0.getFloatArray();
            int maxPos=0;
            float maxConfidence = 0;
            for (int i=0;i<confidences.length;i++){
                if (confidences[i]> maxConfidence){
                    maxConfidence=confidences[i];
                    maxPos = i;
                }
            }
            String[] classes={"Benign","Malignant"};
            result.setText(classes[maxPos]);

            String s="";
            for(int i=0;i<classes.length;i++){
                s=s+ String.format("%s: %.1f%%\n",classes[i],confidences[i]* 100);
            }
            confidence.setText(s);


            // Releases model resources if no longer used.
            model.close();
        } catch (IOException e) {
            // TODO Handle the exception
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==1 && resultCode==RESULT_OK ){
            Bitmap image =(Bitmap) data.getExtras().get("data");
            int dimension = Math.min(image.getWidth(),image.getHeight());
            image = ThumbnailUtils.extractThumbnail(image,dimension,dimension);
            imageView.setImageBitmap(image);

            image =Bitmap.createScaledBitmap(image,imageSize,imageSize,false);
            classifyImage(image);
        }
        else if(requestCode==3 && resultCode==RESULT_OK && data != null)
        {

            imageView= findViewById(R.id.imageView);
            try {
                InputStream inputStream=getContentResolver().openInputStream(data.getData());
                Bitmap image = BitmapFactory.decodeStream(inputStream);
                int dimension = Math.min(image.getWidth(),image.getHeight());
                image = ThumbnailUtils.extractThumbnail(image,dimension,dimension);
                imageView.setImageBitmap(image);
                image =Bitmap.createScaledBitmap(image,imageSize,imageSize,false);
                classifyImage(image);
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
