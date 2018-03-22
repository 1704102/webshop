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

    public int login(String username, String password) {
        connect();
        try {
            while (s.next()){
        ResultSet s = select(String.format("select * from klant where username = '%s' and password = '%s'",username,password));
                return s.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
    }
        disconnect();
        return 0;
        }
    public void addProduct(JsonObject object){
        connect();
        execute(String.format("insert into product (naam, prijs, omschrijving, catagory, plaatje) values ('%s','%s','%s','%s','%s')", object.getString("name"), object.getString("price"), object.getString("description"), object.getString("catagory"), object.getString("image")));
        disconnect();
    }
}