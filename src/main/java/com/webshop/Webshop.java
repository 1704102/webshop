package com.webshop;
import com.webshop.Database.Aanbieding;
import com.webshop.Database.ProductDatabase;
import com.webshop.model.Customer;
import com.webshop.model.Product;
import javax.json.*;
import java.util.ArrayList;

/**
 * Created by marti on 20-3-2018.
 */
public class Webshop {
    ProductDatabase pDatabase = new ProductDatabase();

    ArrayList<Customer> customers;
    ArrayList<Product> products;
    ArrayList<Aanbieding> aanbiedings;

    public Webshop(){
        products = pDatabase.getProducts();
        aanbiedings = getpDatabase().getAanbiedingen();
        aanbiedings.forEach(e->{
            getProductById(e.getId()).setAanbieding(true);
            getProductById(e.getId()).setPrice(e.getPrijs());
        });
    }

    public void addProduct(JsonObject object){
        pDatabase.addProduct(object);
        products.add(pDatabase.getProduct(object.getString("name")));
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

    public ArrayList<Product> getAanbiedingen(){
        ArrayList<Product> output = new ArrayList<>();
        for (Product product : products){
            if(product.isAanbieding() == true){
                output.add(product);
            }
        }
        return output;
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

    public ProductDatabase getpDatabase() {
        return pDatabase;
    }


    public void addOrder(String user, JsonArray array) {
        ArrayList<OrderLine> orderLines = new ArrayList();
        for (int i = 0; i < array.size(); i++) {
            JsonObject jObject = array.getJsonObject(i);
            orderLines.add(new OrderLine(getProductById(Integer.parseInt(jObject.getString("id"))),jObject.getInt("aantal")));
        }
        pDatabase.addOrder(user, orderLines);
    }


    public void alterProduct(JsonObject object) {
        String name = object.getString("name");
        String id = object.getString("id");
        String price = object.getString("price");
        String catagory = object.getString("catagory");
        String image = object.getString("image");
        String description = object.getString("description");
        String s ="";
        if(name.length() > 0){
            s = s + "naam = '" + name + "',";
        }
        if(price.length() > 0){
            s = s + "prijs = " + price + ",";
        }
        if(catagory.length() > 0){
            s = s + "catagory = '" + catagory + "',";
        }
        if(image.length() > 0){
            s = s + "plaatje = '" + image + "',";
        }
        if(description.length() > 0){
            s = s + "omschrijving = '" + description + "',";
        }
        s =  s.substring(0, s.length() - 1);
        s= s + " where id = " + id;
        pDatabase.alterProduct(s);
    }
}
