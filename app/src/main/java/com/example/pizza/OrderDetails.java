package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderDetails extends AppCompatActivity {

///////OrderDetails activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        Order order = (Order) bundle.getSerializable("hello");

        //show total price in OrderDetail activity
        TextView tv = (TextView) findViewById(R.id.totalorderprice);
        tv.setText("Total price = " + String.format("%.02f", order.total) + "$");

        //show pizza size in OrderDetail activity
        TextView tvSize = (TextView) findViewById(R.id.orderSize);
        tvSize.setText("Size of the pizza: " + order.size);

        //show customer's name
        TextView tvName = (TextView) findViewById(R.id.orderName);
        tvName.setText(order.name);

        //show customer's address
        TextView tvAddress = (TextView) findViewById(R.id.orderAddress);
        tvAddress.setText(order.address);

        //show customer's phone number
        TextView tvPhone = (TextView) findViewById(R.id.orderPhone);
        tvPhone.setText(order.phone);

        //show customer's email
        TextView tvEmail = (TextView) findViewById(R.id.orderEmail);
        tvEmail.setText(order.email);

        //show all the selected toppings
        TextView tvTopping1 = (TextView) findViewById(R.id.orderTopping1);
        tvTopping1.setText(String.join(", ", order.toppings));

        //show delivery/pickup option
        TextView tvDelivery = (TextView) findViewById(R.id.orderDelivery);
        tvDelivery.setText(order.delivery);

    }

    //add back button feature for editing order
    public  void editButton(View view) {
        finish();
    }


}