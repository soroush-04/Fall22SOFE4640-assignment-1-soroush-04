package com.example.pizza;

////////Price class for order details

public class Price {

    double size_price;
    double cheese_price = 0;
    double veggie_price = 0;
    double meat_price = 0;
    double top_price =0;
    double delivery_price = 0;

    public double getSize_price() {
        return size_price;
    }

    public void setSize_price(double size_price) {
        this.size_price = size_price;
    }

    public double getCheese_price() {
        return cheese_price;
    }

    public void setCheese_price(double cheese_price) {
        this.cheese_price = cheese_price;
    }

    public double getVeggie_price() {
        return veggie_price;
    }

    public void setVeggie_price(double veggie_price) {
        this.veggie_price = veggie_price;
    }

    public double getMeat_price() {
        return meat_price;
    }

    public void setMeat_price(double meat_price) {
        this.meat_price = meat_price;
    }

    public double getTop_price() {
        return top_price;
    }

    public void setTop_price(double top_price) {
        this.top_price = top_price;
    }

    public double getDelivery_price() {
        return delivery_price;
    }

    public void setDelivery_price(double delivery_price) {
        this.delivery_price = delivery_price;
    }

}
