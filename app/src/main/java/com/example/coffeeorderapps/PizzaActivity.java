package com.example.coffeeorderapps;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PizzaActivity extends AppCompatActivity {



    int quantity = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Pizza Activity");
        actionBar.setDisplayHomeAsUpEnabled(true);



    }



    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        //
        if (quantity == 100) {

            Toast.makeText(this,"You cannot have more than 100 pizza and sandwich", Toast.LENGTH_SHORT).show();

            return;
        }
        quantity = quantity + 1;
        display( quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1){

            Toast.makeText(this, "You cannot have less than 1 pizza and sandwich", Toast.LENGTH_SHORT).show();

            return;
        }
        quantity = quantity - 1;
        display( quantity);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.

     private void displayMessage(String message) {
     TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
     orderSummaryTextView.setText(message);
     }
     */

    /**
     * Calculates the price of the order.
     *
     * @return the total price
     */
    private int calculatePrice(boolean addpizza, boolean hasSandwish) {

        int basePrice = quantity * 5;


        if (addpizza) {
            basePrice = basePrice + 1;
        }


        if (hasSandwish) {
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;
    }

    /**
     * Create summary of the order.
     *
     * @param addpizza is whether or not the user wants whipped cream topping
     * @param hasSandwish is whether or not the user wants chocolate topping
     * @param price of the order
     * @return text summary
     */
    private String createOrderSummary(String name,int price, boolean addpizza, boolean hasSandwish){
        String priceMessage = "Name: " + name;
        priceMessage +=  "\n" + getString(R.string.pizza)+ addpizza;
        priceMessage += "\n" + getString(R.string.sandwish) + hasSandwish;
        priceMessage += "\n"+ getString(R.string.Quantity) + quantity;
        priceMessage += "\n"+ getString(R.string.Total) + price;
        priceMessage += "\n"+ getString(R.string.ThankYou);
        return priceMessage;
    }


    /**
     * This method is called when the order button is clicked.
     * first get the Id of the checkbox then determine the state of the Chechbox using the isChecked()
     *
     */
    public void submitOrder(View view) {

        EditText nameField = (EditText) findViewById(R.id.name_feild);
        String name = nameField.getText().toString();

        CheckBox pizzaCheckBox = (CheckBox) findViewById(R.id.Pizza_checkbox);
        boolean haspizza = pizzaCheckBox.isChecked();

        CheckBox sandwishCheckBox = (CheckBox) findViewById(R.id.Sandwich_checkbox);
        boolean hasSandwish = sandwishCheckBox.isChecked();

        int price = calculatePrice(haspizza, hasSandwish);
        String priceMessage = createOrderSummary(name, price, haspizza, hasSandwish);
        /**
         *  start an Email Intent here so when the user place an order it uses our email app
         * */
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Pizza and Sandwich Order for  " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }



        //displayMessage(priceMessage);



    }


}


