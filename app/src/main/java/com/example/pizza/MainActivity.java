package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Price price;
    TextView total;
    TextView delivery;
    double total_price;
    Order order = new Order();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        price = new Price();
        total = findViewById(R.id.textView8);
        delivery = findViewById(R.id.textView9);

    }

    public void rbClick(View view) {
        //check if button is checked
        boolean checked = ((android.widget.RadioButton) view).isChecked();

        //check which radio button is selected
        switch (view.getId()){
            case R.id.rb1:
                if (checked) {
                    price.setSize_price(7);
                    //save order size to use in OrderDetail activity
                    order.size = "6\"";
                }
                break;

            case R.id.rb2:
                if (checked) {
                    price.setSize_price(9);
                    order.size = "8\"";
                }
                break;

            case R.id.rb3:
                if (checked) {
                    price.setSize_price(11);
                    order.size = "10\"";
                }
                break;

            case R.id.rb4:
                if (checked) {
                    price.setSize_price(13);
                    order.size = "12\"";
                }
                break;
        }

        //updating total price by changing size of the pizza
        total.setText("Total price: " + String.format("%.02f", order_price()) + "$");


    }

    //price calculation for toppings
    public void cbClick(View view) {
        //check if checkbox is selected
        boolean checked = ((android.widget.CheckBox) view).isChecked();

        //check which checkboxes are selected
        switch (view.getId()){
            case R.id.checkBox4:
                if (checked) {
                    //update total price by selecting/deselecting toppings
                    price.setTop_price(2);
                    //save order topping to use in OrderDetail activity
                    order.toppings.add("Bacon");
                }
                else {
                    price.setTop_price(0);
                    order.toppings.remove("Bacon");
                }
                break;

            case R.id.checkBox5:
                if (checked) {
                    price.setMeat_price(2);
                    order.toppings.add("Steak");
                }
                else {
                    price.setMeat_price(0);
                    order.toppings.remove("Steak");
                }
                break;

            case R.id.checkBox6:
                if (checked) {
                    price.setCheese_price(2);
                    order.toppings.add("Extra Cheese");
                }
                else {
                    price.setCheese_price(0);
                    order.toppings.remove("Extra Cheese");
                }
                break;

            case R.id.checkBox7:
                if (checked) {
                    price.setVeggie_price(2);
                    order.toppings.add("Olive");
                }
                else {
                    price.setVeggie_price(0);
                    order.toppings.remove("Olive");
                }
                break;
        }

        total.setText("Total price: " + String.format("%.02f", order_price()) + "$");

    }


    public void switchClick(View view) {

        /*
        Switch switchButton = (Switch) view;
        if(switchButton.isChecked())
            delivery.setText("Delivery option selected!");
        else
            delivery.setText("");
         */

        boolean checked = ((android.widget.Switch) view).isChecked();

        switch (view.getId()) {
            case R.id.switch3:
                if (checked) {
                    //update total by based on delivery option
                    price.setDelivery_price(4);
                    order.delivery = "Delivery option selected!";
                }
                else {
                    price.setDelivery_price(0);
                    order.delivery = "Pickup order!";
                }
                break;
        }

        total.setText("Total price: " + String.format("%.02f", order_price()) + "$");

    }


    //calculating total order price
    private double order_price(){

        total_price = price.getSize_price() + price.getMeat_price() + price.getTop_price() +
                price.getCheese_price() + price.getVeggie_price() + price.getDelivery_price();
        return total_price;

    }

    //submit order button and intent new activity
    public void submitOrderClick(View view) {

        order.total = order_price();
        order.name = ((EditText) findViewById(R.id.editTextTextPersonName)).getText().toString();
        order.address = ((EditText) findViewById(R.id.editTextTextPostalAddress)).getText().toString();
        order.phone = ((EditText) findViewById(R.id.editTextPhone)).getText().toString();
        order.email = ((EditText) findViewById(R.id.editTextTextEmailAddress)).getText().toString();

        Intent intent = new Intent(getBaseContext(), OrderDetails.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("hello", order);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}