package com.webshop.Resources;

import com.webshop.Webshop;
import com.webshop.model.Product;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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

    @Path("/catagory/{catagory}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String Login(@PathParam("catagory") String catagory) {
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
}
