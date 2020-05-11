package com.example.coffeeorderapps;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    private static  int timeout =4000;
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);




        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("About Us");
        actionBar.setDisplayHomeAsUpEnabled(true);



        textView1 = findViewById(R.id.text1ID);
        textView2 = findViewById(R.id.text2ID);
        textView3 = findViewById(R.id.text3ID);
        textView4 = findViewById(R.id.text4ID);
        textView5 = findViewById(R.id.text5ID);
        textView6 = findViewById(R.id.text6ID);
        textView7 = findViewById(R.id.text17ID);
        textView8 = findViewById(R.id.text8ID);

        Animation animation = AnimationUtils.loadAnimation(AboutActivity.this,R.anim.myanimation);
        textView1.startAnimation(animation);
        textView2.startAnimation(animation);
        textView3.startAnimation(animation);
        textView4.startAnimation(animation);
        textView5.startAnimation(animation);
        textView6.startAnimation(animation);
        textView7.startAnimation(animation);
        textView8.startAnimation(animation);
    }
}
