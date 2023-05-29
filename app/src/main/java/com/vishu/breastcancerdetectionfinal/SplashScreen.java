package com.vishu.breastcancerdetectionfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        //code for remove title bar
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //code for hide action bar
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar();

        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent iHome=new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(iHome);
                finish();
            }
        },4000);
    }
}