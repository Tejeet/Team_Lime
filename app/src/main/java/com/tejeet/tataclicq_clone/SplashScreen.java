package com.tejeet.tataclicq_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.tejeet.tataclicq_clone.DataNModels.SharedPrefData;

public class SplashScreen extends AppCompatActivity {

    private SharedPrefData cn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

         cn = new SharedPrefData();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                if (cn.getLoginStatus(SplashScreen.this).equals("1")){
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                }
                else{
                    startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                }

                finish();
            }
        }, 2000);

    }
}