package com.example.uas_akb_10119289;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uas_akb_10119289.R;
import com.example.uas_akb_10119289.main.walkthrough.WalkthroughActivity;

public class MainActivity extends AppCompatActivity {
    private static  int SPLASH_SCREEN = 4000;
    // variables
    Animation topAnim, botAnim;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        botAnim = AnimationUtils.loadAnimation(this, R.anim.bot_anim);

        //Hooks
        image = findViewById(R.id.ss_header);

        image.setAnimation(botAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, WalkthroughActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}