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
            job.add("name", products.get(i).getNaam());
            job.add("price", products.get(i).getPrijs());
            jab.add(job);
        }
        JsonArray array = jab.build();
        return array.toString();



    }

    @Path("/id/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String Login(@PathParam("id") int id) {
        return shop.getProductById(id).toString();

    }

    @Path("/catagory/{catagory}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String Login(@PathParam("catagory") String catagory) {
        return shop.getProductsByCatagory(catagory).toString();

    }
}
