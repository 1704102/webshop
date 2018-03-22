package com.webshop.Resources;

import com.webshop.Webshop;
import com.webshop.model.Product;

import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.StringReader;
import java.util.ArrayList;


/**
 * Created by marti on 13-6-2017.
 */
@Path("product")
public class ProductResource {

    Webshop shop;

    public ProductResource(){
        shop = new Webshop();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String Login() {
        shop.callSoap();
        ArrayList<Product> products = shop.getProducts();
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (int i = 0; i < products.size(); i++) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("id", products.get(i).getId());
            job.add("name", products.get(i).getName());
            job.add("price", products.get(i).getPrice());
            job.add("picture", products.get(i).getPicture());
            jab.add(job);
        }
        JsonArray array = jab.build();
        return array.toString();
    }

    @Path("/id/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String Login(@PathParam("id") int id) {
        Product product = shop.getProductById(id);
        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("id", product.getId());
        job.add("name", product.getName());
        job.add("price", product.getPrice());
        job.add("description", product.getDescription());
        job.add("catagory", product.getCatagory());
        job.add("picture", product.getPicture());
        return job.build().toString();

    }

    @Path("/login/{username}/{password}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public int Login(@PathParam("username") String username,@PathParam("password") String password) {

        return shop.getpDatabase().login(username, password);

    }

    @Path("/catagory/{catagory}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String Login(@PathParam("catagory") String catagory) {
        ArrayList<Product> products = shop.getProductsByCatagory(catagory);
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (int i = 0; i < products.size(); i++) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("id", products.get(i).getId());
            job.add("name", products.get(i).getName());
            job.add("price", products.get(i).getPrice());
            job.add("picture", products.get(i).getPicture());
            job.add("catagory", products.get(i).getCatagory());
            jab.add(job);
        }
        JsonArray array = jab.build();
        return array.toString();

    }

    @Path("/add/{product}")
    @POST
    public void addProduct(@PathParam("product") String product){
        JsonReader jsonReader = Json.createReader(new StringReader(product));
        JsonObject object = jsonReader.readObject();
        jsonReader.close();
        shop.getpDatabase().addProduct(object);
        shop.getProducts().add(shop.getpDatabase().getProduct(object.getString("name")));
    }

    @Path("/delete/{id}")
    @POST
    public void deleteProduct(@PathParam("id") int id){
        shop.getpDatabase().deleteProduct(id);
    }

    @Path("/alter/{product}")
    @POST
    public void alterProduct(@PathParam("product") String product){
        JsonReader jsonReader = Json.createReader(new StringReader(product));
        JsonObject object = jsonReader.readObject();
        jsonReader.close();
        shop.alterProduct(object);
    }

    @Path("/addOrder/{user}/{shoppingcart}")
    @POST
    public void addOrder(@PathParam("user") String user, @PathParam("shoppingcart") String shoppingcart){
        JsonReader jsonReader = Json.createReader(new StringReader(shoppingcart));
        JsonArray array = jsonReader.readArray();
        shop.addOrder(user,array);
        jsonReader.close();

    }
}
