package com.webshop.Database;

import com.webshop.model.Product;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by marti on 23-3-2018.
 */
public class ProductDatabaseTest extends TestCase {
    public void testGetProduct() throws Exception {
        ProductDatabase dat = new ProductDatabase();
        Product p = dat.getProduct("sla");
        Product expected = new Product(6, 2.33, "sla", "het is groen", "eten","sla.png");
        Assert.assertEquals(p.getId(),expected.getId());
        Assert.assertEquals(p.getCatagory(),expected.getCatagory());
        Assert.assertEquals(p.getDescription(),expected.getDescription());
        Assert.assertEquals(p.getName(),expected.getName());
        Assert.assertEquals(p.getPrice(),expected.getPrice());
        Assert.assertEquals(p.getPicture(),expected.getPicture());
    }

}