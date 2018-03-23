package com.webshop.Database;

import com.webshop.OrderLine;
import com.webshop.model.Product;

import javax.json.JsonObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by marti on 20-3-2018.
 */


// prepared statement
public class ProductDatabase extends DatabaseHelper {

    public ArrayList<Product> getProducts(){
        ArrayList<Product> products = new ArrayList<>();
        connect();
        try {
            ResultSet s = select("select * from product");
            while (s.next()) {
                products.add(new Product(s.getInt("id"), s.getInt("prijs"), s.getString("naam"),s.getString("omschrijving"),s.getString("catagorie"), s.getString("picture")));
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
        execute(String.format("insert into product (naam, prijs, omschrijving, catagory, plaatje) values ('%s','%s','%s','nieuw','%s')", object.getString("name"), object.getString("price"), object.getString("description"), object.getString("image")));
        disconnect();
    }

    public Product getProduct(String name){
        Product product = null;
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


    public void deleteProduct(int id) {
       connect();
       try {
           execute(String.format("delete from product where id = %d", id));
       }catch (Exception e){e.printStackTrace();}
       disconnect();
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