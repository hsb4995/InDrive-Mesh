package com.bluetooth.communicatorexample;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.tomer.fadingtextview.FadingTextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class IntroActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity5);

        ImageView imageView = findViewById(R.id.imageview);
        String[] text = { "SSM: Safe Secure Mesh", "A People Driven Safe Network" };

        FadingTextView fadingTextView = findViewById(R.id.textView15);
        fadingTextView.setTexts(text);

        // Adding the gif here using glide library
        Glide.with(this).load(R.drawable.rotated_mesh).into(imageView);

        AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f ) ;
        AlphaAnimation fadeOut = new AlphaAnimation( 1.0f , 0.0f ) ;
        imageView.startAnimation(fadeIn);
        imageView.startAnimation(fadeOut);
        fadeIn.setDuration(400);
        fadeIn.setFillAfter(true);
        fadeOut.setDuration(800);
        fadeOut.setFillAfter(true);
        fadeOut.setStartOffset(4200+fadeIn.getStartOffset());

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                openactivity6();
            }
        }, 5000);
    }
    public void openactivity6(){
        Intent intent = new Intent(this, IntroActivity.class);
        startActivity(intent);
    }
}
