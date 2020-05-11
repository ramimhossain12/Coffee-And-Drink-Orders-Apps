package com.example.coffeeorderapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity   implements View.OnClickListener {


    private CardView coffee,pizza,food,ice,diet,snak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel channel =
                    new NotificationChannel("MyNotifications","MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }

        FirebaseMessaging.getInstance().subscribeToTopic("general")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Successfull";
                        if (!task.isSuccessful()) {
                            msg = "Failed";
                        }

                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

                    }
                });



        coffee = findViewById(R.id.cofffeeID);
        pizza = findViewById(R.id.pizzaID);
        food = findViewById(R.id.somefoodID);
        ice = findViewById(R.id.iceID);
        diet = findViewById(R.id.DietplanID);
        snak = findViewById(R.id.snackID);




        coffee.setOnClickListener(this);
        pizza.setOnClickListener(this);
        food.setOnClickListener(this);
        ice.setOnClickListener(this);
        diet.setOnClickListener(this);
        snak.setOnClickListener(this);



        //now we can create two types of slider first using viewpager
        //and another using third party library which is easy to use let's get started
        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();

        slideModels.add(new SlideModel("https://images.pexels.com/photos/376464/pexels-photo-376464.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","Best Pizza Collection "));
        slideModels.add(new SlideModel("https://cyber-breeze.com/wp-content/uploads/2017/02/featured-image-39.jpg","Pizza "));
        slideModels.add(new SlideModel("https://specials-images.forbesimg.com/imageserve/1152308114/960x0.jpg?fit=scale","Best Coffee Collection"));
        slideModels.add(new SlideModel("https://images.pexels.com/photos/376464/pexels-photo-376464.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940","Click The Butoon"));
        slideModels.add(new SlideModel("https://ichef.bbci.co.uk/news/660/cpsprodpb/3DAD/production/_104898751_gettyimages-844466808.jpg","Many items Food This Apps"));
        slideModels.add(new SlideModel("https://post.healthline.com/wp-content/uploads/sites/3/2020/02/324771_1100-1100x628.jpg","Tea"));

        imageSlider.setImageList(slideModels,true);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    //menu item selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (item.getItemId()==R.id.aboutId){
            Intent intent = new Intent(this,AboutActivity.class);
            startActivity(intent);




        }else if (id==R.id.dateId){
            Intent intent = new Intent(this,DatePicer.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){

            case R.id.cofffeeID:

                startActivity(new Intent(MainActivity.this,CoffeeActivity.class));

                break;


            case  R.id.pizzaID:


                startActivity(new Intent( MainActivity.this,PizzaActivity.class));
                break;

            case  R.id.somefoodID:


                startActivity(new Intent( MainActivity.this,DrinkActivity.class));
                break;

            case  R.id.iceID:


                startActivity(new Intent( MainActivity.this,IceActivity.class));
                break;



            case  R.id.snackID:


                startActivity(new Intent( MainActivity.this,SnacksActivity.class));
                break;



            case  R.id.DietplanID:


                startActivity(new Intent( MainActivity.this,DietActivity.class));
                break;

        }

    }
}

