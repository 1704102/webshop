package com.webshop;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import com.webshop.Database.ProductDatabase;
import com.webshop.model.Customer;
import com.webshop.model.Product;

import javax.json.JsonObject;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by marti on 20-3-2018.
 */
public class Webshop {
    ProductDatabase pDatabase = new ProductDatabase();

    ArrayList<Customer> customers;
    ArrayList<Product> products;

    public Webshop(){
        products = pDatabase.getProducts();
        customers = pDatabase.getCustomers();
    }

    public Product getProductById(int id){
       for (Product product : products){
           if(product.getId() == id){
            return product;
           }
       }
       return null;
    }

    public ArrayList<Product> getProductsByCatagory(String catagory){
        ArrayList<Product> output = new ArrayList<>();
        for (Product product : products){
            if(product.getCatagorie().equals(catagory)){
                output.add(product);
            }
        }
        return output;
    }



    public ArrayList<Product> getProducts(){

        return new ArrayList<>(products);
    }

    public ProductDatabase getpDatabase() {
        return pDatabase;
    }

    public void addOrder(JsonObject object) {
        pDatabase.addOrder(object);
    }
}