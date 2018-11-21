package me.vedant.interntask.prototype;

import java.io.Serializable;

/**
 * Created by vedant on 11/21/2018.
 */

public class CrickPrototype implements Serializable{
    String team1, team2, series, inn1, inn2, host;

    public CrickPrototype(String team1, String team2, String series, String inn1, String inn2, String host) {
        this.team1 = team1;
        this.team2 = team2;
        this.series = series;
        this.inn1 = inn1;
        this.inn2 = inn2;
        this.host = host;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getInn1() {
        return inn1;
    }

    public void setInn1(String inn1) {
        this.inn1 = inn1;
    }

    public String getInn2() {
        return inn2;
    }

    public void setInn2(String inn2) {
        this.inn2 = inn2;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
