package com.elicastrillon.turismocaceres;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
 private static final long SPLASH_DELAY = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// modeo de pantalla solo vertical

        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE); // Titulo quitado

        setContentView(R.layout.activity_splash);



        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent().setClass(Splash.this,Login.class);
                startActivity(i);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_DELAY );
    }
}
