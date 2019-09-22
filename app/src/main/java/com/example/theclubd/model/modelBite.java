package com.example.theclubd.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class modelBite implements Serializable {
    int id;
    String cname;
    String lname;
    String bite;
    String sdrink;
    String price;
    String des;

    public modelBite(String cname, String lname, String bite, String sdrink, String price, String des) {
        this.cname = cname;
        this.lname = lname;
        this.bite = bite;
        this.sdrink = sdrink;
        this.price = price;
        this.des = des;
    }

    public modelBite(int id, String cname, String lname, String bite, String sdrink, String price, String des) {
        this.id = id;
        this.cname = cname;
        this.lname = lname;
        this.bite = bite;
        this.sdrink = sdrink;
        this.price = price;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getBite() {
        return bite;
    }

    public void setBite(String bite) {
        this.bite = bite;
    }

    public String getSdrink() {
        return sdrink;
    }

    public void setSdrink(String sdrink) {
        this.sdrink = sdrink;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @NonNull
    @Override
    public String toString() {
        return cname;
    }
}

