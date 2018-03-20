package com.webshop.Database;

import com.sun.org.apache.regexp.internal.RE;
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


}
