package com.webshop.Resources;

import com.webshop.Database.DatabaseHelper;
import com.webshop.Webshop;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by marti on 13-6-2017.
 */
@Path("product")
public class ProductResource {

    Webshop shop;

    public ProductResource(){
        shop = new Webshop();
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
    public String Login(@QueryParam("catagory") String catagory) {
        return shop.getProductsByCatagory(catagory).toString();

    }
}
