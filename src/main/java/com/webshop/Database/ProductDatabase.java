package com.webshop.Database;

import com.sun.org.apache.regexp.internal.RE;
import com.webshop.model.Product;
import sun.security.util.Resources_sv;

import javax.json.JsonObject;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                products.add(new Product(s.getInt("id"), s.getDouble("prijs"), s.getString("naam"),s.getString("omschrijving"),s.getString("catagory"),s.getString("plaatje")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        disconnect();
        return products;
    }

    public void addProduct(JsonObject object){
        connect();
        execute(String.format("insert into product (naam, prijs, omschrijving, catagory, plaatje) values ('%s','%s','%s','%s','%s')", object.getString("name"), object.getString("price"), object.getString("description"), object.getString("catagory"), object.getString("image")));
        disconnect();
    }

    public Product getProduct(String name){
        Product product = null;
        try {
            connect();
            ResultSet s = select(String.format("select * from product where naam = '%s'", name));
            while (s.next()) {
                product = new Product(s.getInt("id"), s.getDouble("prijs"), s.getString("naam"), s.getString("omschrijving"), s.getString("catagory"), s.getString("plaatje"));
            }
            disconnect();
            }catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }


    public void addOrder(JsonObject object) {
        //execute();
    }

    public int login(String username, String password) {
        connect();
        ResultSet s = select(String.format("select * from klant where username = '%s' and password = '%s'",username,password));
        try {
            while (s.next()){
                return s.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return 0;
    }
}
