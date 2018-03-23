package com.webshop.Database;

/**
 * Created by marti on 22-3-2018.
 */
public class Aanbieding {
    int id;
    double prijs;

    public Aanbieding(int id, double prijs) {
        this.id = id;
        this.prijs = prijs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
}
