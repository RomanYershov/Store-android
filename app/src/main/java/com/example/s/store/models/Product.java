package com.example.s.store.models;

import android.widget.ImageView;

public class Product {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product(int id, String name, int price, int image) {
        this.id = id;

        this.name = name;
        this.price = price;
        this.image = image;
    }

    private int id;
    private String name;
    private int price;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
