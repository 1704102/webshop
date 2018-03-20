package com.webshop.model;

import java.util.ArrayList;

/**
 * Created by marti on 20-3-2018.
 */
public class Product {
    int id, price;
    String name, description, catagory, picture;
    ArrayList<String> catagorys;

    public Product(int id, int price, String name, String description, String catagory, String picture) {
        this.id = id;
        this.price = price;
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

    public int getPrice() {
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
}
