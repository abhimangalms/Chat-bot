package com.abhimangal.project.gk_chatbot.Ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.abhimangal.project.gk_chatbot.R;

import java.net.Inet4Address;

public class SplashScreenActivity extends AppCompatActivity {

    static final String MY_PREFS_NAME = "LOGIN_PREFERENCE";
    static final String MY_LOGIN_CREDENTIAL = "IS_LOGGED_N";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SharedPreferences sharedPreferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //This method is used so that your splash activity
        //can cover the entire screen.

        setContentView(R.layout.activity_splash_screen);
        //this will bind your MainActivity.class file with activity_main.

        int SPLASH_SCREEN_TIME_OUT = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = null;
                if (sharedPreferences.contains(MY_LOGIN_CREDENTIAL)) {
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                } else {
                    intent = new Intent(getApplicationContext(), LoginActivity.class);

                }
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}