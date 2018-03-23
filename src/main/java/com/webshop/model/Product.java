package com.webshop.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by marti on 20-3-2018.
 */
public class Product {
    int id;
    double price;
    String name, description, catagory, picture;
    ArrayList<String> catagorys;
    boolean aanbieding = false;

    public Product(int id, double price, String name, String description, String catagory, String picture) {
        this.id = id;
        this.price = Math.round(price * 100.0) / 100.0;
        this.name = name;
        this.description = description;
        this.catagory = catagory;
        this.picture = picture;
    }

    public int getId(){
        return id;
    }

    public String getCatagory(){
        return catagory;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public boolean isAanbieding() {
        return aanbieding;
    }

    public void setAanbieding(boolean aanbieding) {
        this.aanbieding = aanbieding;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
