package com.webshop.Database;

import com.sun.org.apache.regexp.internal.RE;
import com.webshop.model.Customer;
import com.webshop.model.Product;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by marti on 20-3-2018.
 */
public class ProductDatabase extends DatabaseHelper {

    public ArrayList<Product> getProducts(){
        ArrayList<Product> products = new ArrayList<>();
        connect();
        try {
            ResultSet s = select("select * from product");
            while (s.next()) {
                products.add(new Product(s.getInt("id"), s.getInt("prijs"), s.getString("naam"),s.getString("omschrijving"),s.getString("catagorie")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        disconnect();
        return products;
    }


    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        connect();
        try {
            ResultSet s = select("select * from klant");
            while (s.next()) {
                customers.add(new Customer(s.getInt("id"), s.getInt("adres_id"), s.getString("naam"),s.getString("password")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        disconnect();
        return customers;
    }

    public boolean addCustomer(Customer customer){
        connect();
        try{
            execute(String.format("INSERT INTO klant (naam, password) VALUES({%s,%s})",customer.getName(), customer.getPassword()));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
