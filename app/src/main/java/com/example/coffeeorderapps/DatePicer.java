package com.example.coffeeorderapps;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatePicer extends AppCompatActivity {

    private TextView textView ;
    private android.widget.DatePicker datePicker ;
    private Button selectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picer);





        textView = (TextView)findViewById(R.id.textViewID);
        selectButton =(Button)findViewById(R.id.buttonID);
        datePicker =(android.widget.DatePicker)findViewById(R.id.datepiccerID);
        textView.setText(currentDate());

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(currentDate());
            }
        });


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("DatePicker");
        actionBar.setDisplayHomeAsUpEnabled(true);



    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;

    }
    String currentDate(){


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CurrentDate :");
        stringBuilder.append(datePicker.getDayOfMonth()+"/");
        stringBuilder.append((datePicker.getMonth()+1)+"/");
        stringBuilder.append(datePicker.getYear());

        return stringBuilder.toString();
    }
}
