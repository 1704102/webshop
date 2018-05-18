package com.webshop.Resources;

import com.webshop.Webshop;
import com.webshop.model.Product;

import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    public String getProducts() {
        ArrayList<Product> products = shop.getProducts();
        JsonArrayBuilder jab = Json.createArrayBuilder();
        getProducts(products, jab);
        JsonArray array = jab.build();
        return array.toString();
    }



    @GET
    @Path("/aanbieding")
    @Produces(MediaType.APPLICATION_JSON)
    public String Aanbieding() {
        ArrayList<Product> products = shop.getAanbiedingen();
        JsonArrayBuilder jab = Json.createArrayBuilder();
        getProducts(products, jab);
        JsonArray array = jab.build();
        return array.toString();
    }

    private void getProducts(ArrayList<Product> products, JsonArrayBuilder jab) {
        for (Product product : products) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("id", product.getId());
            job.add("name", product.getName());
            job.add("price", product.getPrice());
            job.add("picture", product.getPicture());
            jab.add(job);
        }
    }

    @Path("/order/{user}/{shoppingcart}")
    @POST
    public void addOrder(@PathParam("user") String user, @PathParam("shoppingcart") String shoppingcart){
        JsonReader jsonReader = Json.createReader(new StringReader(shoppingcart));
        JsonArray array = jsonReader.readArray();
        shop.addOrder(user,array);
        jsonReader.close();

    }

    @Path("/id/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProduct(@PathParam("id") int id) {
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

    @Path("/id/{id}")
    @DELETE
    public Response deleteProduct(@PathParam("id") int id){
        try {
            shop.getpDatabase().deleteProduct(id);
        }catch (Exception e){
            return Response.status(303).build();
        }
        return Response.status(200).build();
    }

    @Path("/id/{product}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response alterProduct(InputStream incomingData){

        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line;
            while ((line = in.readLine()) != null) {
                stringBuilder.append(line);
            }
            shop.alterProduct(Json.createReader(new StringReader(stringBuilder.toString())).readObject());
        } catch (Exception e) {
            return Response.status(303).build();
        }

        // return HTTP response 200 in case of success
        return Response.status(200).entity(stringBuilder.toString()).build();

        /*JsonReader jsonReader = Json.createReader(new StringReader(product));
        JsonObject object = jsonReader.readObject();
        jsonReader.close();
        shop.alterProduct(object);*/
    }

    @Path("/login/{username}/{password}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public int login(@PathParam("username") String username,@PathParam("password") String password) {

        return shop.getpDatabase().login(username, password);

    }

    @Path("/catagory/{catagory}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String Login(@PathParam("catagory") String catagory) {
        ArrayList<Product> products = shop.getProductsByCatagory(catagory);
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Product product : products) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("id", product.getId());
            job.add("name", product.getName());
            job.add("price", product.getPrice());
            job.add("picture", product.getPicture());
            job.add("catagory", product.getCatagory());
            jab.add(job);
        }
        JsonArray array = jab.build();
        return array.toString();

    }




}
