package com.vishu.breastcancerdetectionfinal;

import static com.vishu.breastcancerdetectionfinal.R.id.pdfView;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class BreastExcercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breast_excercises);

       PDFView pdfViewExcercise=findViewById(R.id.pdfView_one);

        pdfViewExcercise.fromAsset("excercises.pdf")
                .pages(0, 2, 3, 4, 5,7,8,9,10) // all pages are displayed by default
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(0)
//                .invalidPageColor(Color.WHITE) // color of page that is invalid and cannot be loaded
                .load();

    }
}