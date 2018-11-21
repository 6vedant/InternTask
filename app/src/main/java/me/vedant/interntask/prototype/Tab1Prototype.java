package me.vedant.interntask.prototype;

import java.io.Serializable;

/**
 * Created by vedant on 11/21/2018.
 */

public class Tab1Prototype implements Serializable {
    String team1_name, team2_name, host_name, series_name, inn1_score, inn2_score, match_result, team1_image_url, team2_image_url;


    public Tab1Prototype(String team1_name, String team2_name, String host_name,
                         String series_name, String inn1_score, String inn2_score,
                         String match_result, String team1_image_url, String team2_image_url) {
        this.team1_name = team1_name;
        this.team2_name = team2_name;
        this.host_name = host_name;
        this.series_name = series_name;
        this.inn1_score = inn1_score;
        this.inn2_score = inn2_score;
        this.match_result = match_result;
        this.team1_image_url = team1_image_url;
        this.team2_image_url = team2_image_url;
    }

    public String getTeam1_name() {
        return team1_name;
    }

    public void setTeam1_name(String team1_name) {
        this.team1_name = team1_name;
    }

    public String getTeam2_name() {
        return team2_name;
    }

    public void setTeam2_name(String team2_name) {
        this.team2_name = team2_name;
    }

    public String getHost_name() {
        return host_name;
    }

    public void setHost_name(String host_name) {
        this.host_name = host_name;
    }

    public String getSeries_name() {
        return series_name;
    }

    public void setSeries_name(String series_name) {
        this.series_name = series_name;
    }

    public String getInn1_score() {
        return inn1_score;
    }

    public void setInn1_score(String inn1_score) {
        this.inn1_score = inn1_score;
    }

    public String getInn2_score() {
        return inn2_score;
    }

    public void setInn2_score(String inn2_score) {
        this.inn2_score = inn2_score;
    }

    public String getMatch_result() {
        return match_result;
    }

    public void setMatch_result(String match_result) {
        this.match_result = match_result;
    }

    public String getTeam1_image_url() {
        return team1_image_url;
    }

    public void setTeam1_image_url(String team1_image_url) {
        this.team1_image_url = team1_image_url;
    }

    public String getTeam2_image_url() {
        return team2_image_url;
    }

    public void setTeam2_image_url(String team2_image_url) {
        this.team2_image_url = team2_image_url;
    }
}
