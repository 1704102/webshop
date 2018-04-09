package com.webshop;
import com.webshop.Model.Aanbieding;
import com.webshop.Model.Customer;
import com.webshop.Model.Product;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.DB;
import org.javalite.activejdbc.LazyList;

/**
 * Created by marti on 20-3-2018.
 */
public class Webshop {

    private LazyList<Customer> customers;
    private LazyList<Product> products;
    private LazyList<Aanbieding> aanbiedings;

    public LazyList<Customer> getCustomers() {
        return customers;
    }
    public LazyList<Product> getProducts() {
        return products;
    }
    public LazyList<Aanbieding> getAanbiedings() {
        return aanbiedings;
    }




    public Webshop(){
        Base.open();

        products = Product.findAll();
        aanbiedings = Aanbieding.findAll();
        customers = Customer.findAll();
        DB.closeAllConnections();
        //TODO: find all products with aanbieding
    }

    /*public void addProduct(JsonObject object){
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
    }*/
}