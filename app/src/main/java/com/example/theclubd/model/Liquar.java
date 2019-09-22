package com.example.theclubd.model;

import java.io.Serializable;

public class Liquar implements Serializable {

    int id;
    String name;
    String brand;
    String type;
    int vol;
    int per;
    int price;
    String batch;

    public Liquar(String name, String brand, String type, int vol, int per, int price, String batch) {
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.vol = vol;
        this.per = per;
        this.price = price;
        this.batch = batch;
    }

    public Liquar(int id, String name, String brand, String type, int vol, int per, int price, String batch) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.vol = vol;
        this.per = per;
        this.price = price;
        this.batch = batch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public int getPer() {
        return per;
    }

    public void setPer(int per) {
        this.per = per;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    @Override
    public String toString() {
        return name;
    }
}

