package com.gamedevelopment.esdny.gamedevelopment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Splash_Screen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash__screen);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        final Button myButton = (Button) findViewById(R.id.StartButton);
        TextView Instructions = (TextView) findViewById(R.id.instructionsTextView) ;

        Instructions.setText("Welcome to The Concentration Game.\n" +
                "This app is a simple game that helps you strengthen your memory span.\n" +
                "How Does It Work?"+
                "\n" +
                "The app gives you a grid of numbers which are placeholders for an emoji. Click on top of any number and then another to try to match pairs.\n" +
                "Once a pair is found you there will be a few seconds pause then the emoji’s will disappear. After they disappear a piece of the background will be revealed so you can see a piece of the picture of an animal.\n" +
                " YOUR GOAL IS TO GUESS THE ANIMAL.\n" +
                "\n" +
                "At any point of the game, you could guess the name of the animal by typing the name in the “Guess the animal textbox” followed by pressing the button “Try”. If the animal is the right animal, you win.\n" +
                "\n" +
                "I hope you have fun\n" +
                "Truly Yours,\n" +
                "The Developer.");

        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                finish();
                startActivity(new Intent(Splash_Screen.this,MainActivity.class ));
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
