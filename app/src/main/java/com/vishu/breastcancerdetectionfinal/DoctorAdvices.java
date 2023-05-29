package com.vishu.breastcancerdetectionfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.security.PrivateKey;

public class DoctorAdvices extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_advices);

         webView=findViewById(R.id.webView);
         webView.setWebViewClient(new WebViewClient());
         webView.loadUrl("https://www.practo.com/gorakhpur/doctors-for-breast-pain");

        WebSettings webSettings =webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}