package com.webshop;

import com.webshop.Database.ProductDatabase;
import com.webshop.model.Customer;
import com.webshop.model.Product;

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
    }

    public ArrayList<Product> getProducts(){
        ArrayList<Product> output = new ArrayList<>();
        for (Product product : products){
                output.add(product);
        }
        return output;
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
            if(product.getCatagory().equals(catagory)){
                output.add(product);
            }
        }
        return output;
    }



}
