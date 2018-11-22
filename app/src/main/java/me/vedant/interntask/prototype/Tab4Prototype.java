package me.vedant.interntask.prototype;

import java.util.ArrayList;

/**
 * Created by vedant on 11/22/2018.
 */

public class Tab4Prototype {
    String series_name;
    ArrayList<Tab1Prototype> tab1Prototypes;


    public Tab4Prototype(String series_name, ArrayList<Tab1Prototype> tab1Prototypes) {
        this.series_name = series_name;
        this.tab1Prototypes = tab1Prototypes;
    }

    public String getSeries_name() {
        return series_name;
    }

    public void setSeries_name(String series_name) {
        this.series_name = series_name;
    }

    public ArrayList<Tab1Prototype> getTab1Prototypes() {
        return tab1Prototypes;
    }

    public void setTab1Prototypes(ArrayList<Tab1Prototype> tab1Prototypes) {
        this.tab1Prototypes = tab1Prototypes;
    }
}
