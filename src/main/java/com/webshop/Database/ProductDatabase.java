package com.webshop.Database;

import com.sun.org.apache.regexp.internal.RE;
import com.webshop.OrderLine;
import com.webshop.model.Product;
import sun.security.util.Resources_sv;

import javax.json.JsonObject;
import java.lang.reflect.Array;
import java.sql.PreparedStatement;
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
        execute(String.format("insert into product (naam, prijs, omschrijving, catagory, plaatje) values ('%s','%s','%s','nieuw','%s')", object.getString("name"), object.getString("price"), object.getString("description"), object.getString("image")));
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


    public void deleteProduct(int id) {
       connect();
       try {
           execute(String.format("delete from product where id = %d", id));
       }catch (Exception e){e.printStackTrace();}
       disconnect();
    }

    public int login(String username, String password) {
        connect();
        int id = 0;
        try {
            String sql = "select * from klant where username = ? and password = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet s = pstmt.executeQuery();
            while (s.next()) {
                id = s.getInt("id");
            }
            disconnect();
        }catch (Exception e){

        }
        return id;
    }

    public void addOrder(String user, ArrayList<OrderLine> orderLines) {
        connect();
        try{
           execute(String.format("insert into bestelling (klant_id, status) values (%d, 'new') ",Integer.parseInt(user)));
           ResultSet s = select("select max(id) as id from bestelling");
           int id = 0;
           while (s.next()){
               id = s.getInt("id");
           }
            int finalId = id;
            orderLines.forEach(e->{
               execute(String.format("insert into bestellingsregel (order_id, product_id, aantal) values (%d,%d,%d)", finalId, e.getProduct().getId(), e.getAmount()));
           });



        }catch (Exception e){

        }
        disconnect();
    }

    public void alterProduct(String subquery) {
        connect();
        System.out.println("update product set " + subquery);
        execute("update product set " + subquery);
        disconnect();
    }

    public ArrayList<Aanbieding> getAanbiedingen(){
        ArrayList<Aanbieding> aanbiedingen = new ArrayList();
        connect();
        try{
            ResultSet s = select("select * from aanbieding");
            while (s.next()){
                aanbiedingen.add(new Aanbieding(s.getInt("product_id"), s.getDouble("nieuwe_prijs")));
            }
        }catch (Exception e){}
        disconnect();
        return aanbiedingen;
    }
}
