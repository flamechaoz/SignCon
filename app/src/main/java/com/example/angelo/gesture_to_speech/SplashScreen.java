package com.example.angelo.gesture_to_speech;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    MediaPlayer welcomesound;
    private ImageView iv;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        iv = (ImageView)findViewById(R.id.iv);
        tv = (TextView)findViewById(R.id.tv);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.myanimation);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);

        welcomesound = MediaPlayer.create(SplashScreen.this, R.raw.mediasound);
        welcomesound.start();


        final Intent i = new Intent (this, Menu.class);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
