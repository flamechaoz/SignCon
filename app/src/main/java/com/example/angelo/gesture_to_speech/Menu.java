package com.example.angelo.gesture_to_speech;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

public class Menu extends AppCompatActivity {

    Button menu;
    ImageView gesture, tutorial, asldictionary, texttospeech, exit1, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("SignCon");

        gesture = (ImageView)findViewById(R.id.gesture);
        tutorial = (ImageView)findViewById(R.id.tutorial);
        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowcaseConfig config = new ShowcaseConfig();
                config.setDelay(500);

                MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(Menu.this);
                sequence.setConfig(config);
                sequence.addSequenceItem(asldictionary, "Learn more hand gesture", "next");
                sequence.addSequenceItem(texttospeech, "Convert text into speech", "next");
                sequence.addSequenceItem(tutorial, "Open the app tutorial again", "next");
                sequence.addSequenceItem(gesture, "Start converting hand gestures into speech", "next");
                sequence.addSequenceItem(about, "About the app", "next");
                sequence.addSequenceItem(exit1, "Exit the app", "got it");
                sequence.start();
            }
        });

        asldictionary = (ImageView)findViewById(R.id.asldictionary);
        asldictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Menu.this, ASL.class);

                startActivity(i);
            }
        });

        texttospeech = (ImageView)findViewById(R.id.texttospeech);
        texttospeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(Menu.this, TexttoSpeech.class);
                startActivity(i);
            }
        });

        about = (ImageView)findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, AboutActivity.class);
                startActivity(intent);
            }
        });


        exit1 = (ImageView)findViewById(R.id.exit1);
        exit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Menu.this);
                alertDialogBuilder.setMessage("Are you sure to exit?");

                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                        //finishAffinity(); to destroy all
                    }

                });

                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //doing Nothing
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(android.view.Menu menu) {
//        return super.onCreateOptionsMenu(menu);
//    }

    public void gesture(View view){
        Intent intent = new Intent(Menu.this, GestureMenu.class);
        startActivity(intent);
    }

}
