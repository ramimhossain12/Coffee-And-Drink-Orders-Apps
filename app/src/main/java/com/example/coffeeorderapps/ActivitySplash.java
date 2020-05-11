package com.example.coffeeorderapps;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivitySplash extends AppCompatActivity {

    ImageView img;
    TextView text1;
    TextView text2;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);



        img = findViewById(R.id.imageID);
        text1 = findViewById(R.id.text1ID);
        text2 = findViewById(R.id.text2ID);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                statEnterAnimation();
            }
        },1000);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ActivitySplash.this,MainActivity.class));
            }
        },4000);

    }

    private void statExitAnimation() {

        img.startAnimation(AnimationUtils.loadAnimation(this,R.anim.iamge_in));
        text1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.text_in));
        text2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.text_in));
        img.setVisibility(View.VISIBLE);
        text1.setVisibility(View.VISIBLE);
        text2.setVisibility(View.VISIBLE);
    }

    private void statEnterAnimation() {

        img.startAnimation(AnimationUtils.loadAnimation(this,R.anim.inage_our));
        text1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.text_out));
        text2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.text_out));
        img.setVisibility(View.INVISIBLE);
        text1.setVisibility(View.INVISIBLE);
        text2.setVisibility(View.INVISIBLE);
    }
}
