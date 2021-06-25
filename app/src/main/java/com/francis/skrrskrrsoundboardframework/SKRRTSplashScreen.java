package com.francis.skrrskrrsoundboardframework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;



public class SKRRTSplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN=1000;
    //Variables
    Animation logoAnim;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_k_r_r_t_splash_screen);

        //Animations
        logoAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);

        //Hooks
        logo = findViewById(R.id.logo);

        logo.setAnimation(logoAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SKRRTSplashScreen.this, MainActivity.class);
                startActivity(intent);

                finish();

            }
        }, SPLASH_SCREEN);


    }


}

