package com.example.coffeeorderapps;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class DietActivity extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        textView = findViewById(R.id.textViewID);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("DietActivity");
        actionBar.setDisplayHomeAsUpEnabled(true);

    }
}
