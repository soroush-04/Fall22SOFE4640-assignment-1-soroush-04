package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderDetails extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        Order order = (Order) bundle.getSerializable("hello");

        TextView tv = (TextView) findViewById(R.id.totalorderprice);
        tv.setText("Total price = " + String.format("%.02f", order.total) + "$");

        TextView tvSize = (TextView) findViewById(R.id.orderSize);
        tvSize.setText("Size of the pizza: " + order.size);

        TextView tvName = (TextView) findViewById(R.id.orderName);
        tvName.setText(order.name);

        TextView tvAddress = (TextView) findViewById(R.id.orderAddress);
        tvAddress.setText(order.address);

        TextView tvPhone = (TextView) findViewById(R.id.orderPhone);
        tvPhone.setText(order.phone);

        TextView tvEmail = (TextView) findViewById(R.id.orderEmail);
        tvEmail.setText(order.email);

        TextView tvTopping1 = (TextView) findViewById(R.id.orderTopping1);
        tvTopping1.setText(String.join(", ", order.toppings));

//        TextView tvTopping2 = (TextView) findViewById(R.id.orderTopping2);
//        tvTopping2.setText(order.topping2);
//
//        TextView tvTopping3 = (TextView) findViewById(R.id.orderTopping3);
//        tvTopping3.setText(order.topping3);
//
//        TextView tvTopping4 = (TextView) findViewById(R.id.orderTopping4);
//        tvTopping4.setText(order.topping4);

        TextView tvDelivery = (TextView) findViewById(R.id.orderDelivery);
        tvDelivery.setText(order.delivery);

    }

    //add back button feature for editing order
    public  void editButton(View view) {
        finish();
    }


}