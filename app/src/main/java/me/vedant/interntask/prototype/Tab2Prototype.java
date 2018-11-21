package me.vedant.interntask.prototype;

import java.util.ArrayList;

/**
 * Created by vedant on 11/22/2018.
 */

public class Tab2Prototype {

    String country_name;
    ArrayList<Tab1Prototype> tab1Prototypes;
    String country_url;


    public Tab2Prototype(String country_name, ArrayList<Tab1Prototype> tab1Prototypes, String country_url) {
        this.country_name = country_name;
        this.tab1Prototypes = tab1Prototypes;
        this.country_url = country_url;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public ArrayList<Tab1Prototype> getTab1Prototypes() {
        return tab1Prototypes;
    }

    public void setTab1Prototypes(ArrayList<Tab1Prototype> tab1Prototypes) {
        this.tab1Prototypes = tab1Prototypes;
    }

    public String getCountry_url() {
        return country_url;
    }

    public void setCountry_url(String country_url) {
        this.country_url = country_url;
    }
}