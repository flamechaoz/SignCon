package com.example.angelo.gesture_to_speech;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ASL extends AppCompatActivity {

    MediaPlayer asldic;

    WebView mywebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asl);
        asldic = MediaPlayer.create(ASL.this, R.raw.signdic);
        asldic.start();

        mywebView = (WebView)findViewById(R.id.tutorial);
        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebView.loadUrl("http://handspeak.com/");
        // Line of Code for opening links in app
        mywebView.setWebViewClient(new WebViewClient());
    }
}
