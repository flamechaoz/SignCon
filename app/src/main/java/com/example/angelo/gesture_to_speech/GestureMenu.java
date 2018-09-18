package com.example.angelo.gesture_to_speech;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class GestureMenu extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_menu);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null){
            actionBar.setTitle("Gesture");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void letters(View view){
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.signconletters.org.customvision_sample");

        if(launchIntent != null){
            startActivity(launchIntent);
        }
        else{
            Toast.makeText(GestureMenu.this, "Gesture module not found!", Toast.LENGTH_SHORT).show();
        }
    }

    public void words(View view){
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.signconwords.org.customvision_words");

        if(launchIntent != null){
            startActivity(launchIntent);
        }
        else{
            Toast.makeText(GestureMenu.this, "Gesture module not found!", Toast.LENGTH_SHORT).show();
        }
    }

    public void numbers(View view){
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.signconnumbers.org.customvision_numbers");

        if(launchIntent != null){
            startActivity(launchIntent);
        }
        else{
            Toast.makeText(GestureMenu.this, "Gesture module not found!", Toast.LENGTH_SHORT).show();
        }
    }
}
