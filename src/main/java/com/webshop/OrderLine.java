package com.webshop;

import com.webshop.model.Product;

/**
 * Created by marti on 22-3-2018.
 */
public class OrderLine {
    Product product;
    int amount;

    public OrderLine(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
