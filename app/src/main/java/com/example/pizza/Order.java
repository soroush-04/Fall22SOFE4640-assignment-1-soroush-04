package com.example.pizza;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {

    String size;
    ArrayList<String> toppings = new ArrayList<>();
    String topping1;
    String topping2;
    String topping3;
    String topping4;
    String delivery = "Pickup order!";
    double total;
    String name;
    String address;
    String phone;
    String email;
}
