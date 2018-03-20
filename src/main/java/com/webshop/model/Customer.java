package com.webshop.model;

/**
 * Created by marti on 20-3-2018.
 */
public class Customer {
    public Customer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdres() {
        return adres;
    }

    public void setAdres(int adres) {
        this.adres = adres;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int id;
    int adres;
    String password;
    String name;

    public Customer(int id, int adres_id, String naam, String password) {
        this.id = id;
        this.adres = adres_id;
        this.password = password;
        this.name = naam;
    }
}
