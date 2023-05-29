package com.vishu.breastcancerdetectionfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Toast;

import com.vishu.breastcancerdetectionfinal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AboutBreastCancerActivity.class));

            }
        });

        binding.cvSelfExaming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SelfExaming.class));
            }
        });


        binding.cvBreastExcercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BreastExcercises.class));
            }
        });

        binding.DoctorAdvices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DoctorAdvices.class));
            }
        });

        binding.cvFaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FAQ.class));
            }
        });

        binding.cvDetection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,CancerDetectionActivity.class));
                Intent intent =new Intent(getApplicationContext(),CancerDetectionActivity.class);
                startActivity(intent);
            }
        });
    }
}