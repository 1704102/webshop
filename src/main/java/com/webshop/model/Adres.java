package com.webshop.model;

/**
 * Created by marti on 20-3-2018.
 */
public class Adres {
    int id;
    String stad,straat,straatnummer,postcode;

    public Adres(int id, String stad, String straat, String straatnummer, String postcode) {
        this.id = id;
        this.stad = stad;
        this.straat = straat;
        this.straatnummer = straatnummer;
        this.postcode = postcode;
    }
}
