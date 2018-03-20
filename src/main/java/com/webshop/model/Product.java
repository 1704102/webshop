package com.webshop.model;

/**
 * Created by marti on 20-3-2018.
 */
public class Product {
    int id, prijs;
    String naam, omschrijving, catagorie;

    public Product(int id, int prijs, String naam, String omschrijving, String catagorie) {
        this.id = id;
        this.prijs = prijs;
        this.naam = naam;
        this.omschrijving = omschrijving;
        this.catagorie = catagorie;
    }

    public int getId(){
        return id;
    }

    public String getCatagorie(){
        return catagorie;
    }

    public int getPrijs() {
        return prijs;
    }

    public String getNaam() {
        return naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }
}
