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

public class IceActivity extends AppCompatActivity {
    int quantity = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ice);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Ice Cream Activity");
        actionBar.setDisplayHomeAsUpEnabled(true);

    }



    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        //
        if (quantity == 100) {

            Toast.makeText(this,"You cannot have more than 100 Ice Cream", Toast.LENGTH_SHORT).show();

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

            Toast.makeText(this, "You cannot have less than 1 Ice Cream", Toast.LENGTH_SHORT).show();

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
    private int calculatePrice(boolean addbanana, boolean hasblack) {

        int basePrice = quantity * 5;


        if (addbanana) {
            basePrice = basePrice + 1;
        }


        if (hasblack) {
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;
    }

    /**
     * Create summary of the order.
     *
     * @param addbanana is whether or not the user wants whipped cream topping
     * @param hasblack is whether or not the user wants chocolate topping
     * @param price of the order
     * @return text summary
     */
    private String createOrderSummary(String name,int price, boolean addbanana, boolean hasblack){
        String priceMessage = "Name: " + name;
        priceMessage +=  "\n" + getString(R.string.banana)+ addbanana;
        priceMessage += "\n" + getString(R.string.blackberry) + hasblack;
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

        CheckBox bananaCheckBox = (CheckBox) findViewById(R.id.bananaIce_checkbox);
        boolean addbanana = bananaCheckBox.isChecked();

        CheckBox balckCheckBox = (CheckBox) findViewById(R.id.blckICe_checkbox);
        boolean hasblack = balckCheckBox.isChecked();

        int price = calculatePrice(addbanana, hasblack);
        String priceMessage = createOrderSummary(name, price, addbanana, hasblack);
        /**
         *  start an Email Intent here so when the user place an order it uses our email app
         * */
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Ice Order for  " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }







    }


}



