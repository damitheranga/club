package com.example.theclubd.model;

import java.io.Serializable;

public class Owner implements Serializable {
    int id;
    String OwnerName;
    String email;
    String NIC;
    String ShopName;
    String RegisterNo;
    String ContactNo;
    String Address;

    public Owner(String ownerName, String email, String NIC, String shopName, String registerNo, String contactNo, String address) {
        OwnerName = ownerName;
        this.email = email;
        this.NIC = NIC;
        ShopName = shopName;
        RegisterNo = registerNo;
        ContactNo = contactNo;
        Address = address;
    }

    public Owner(int id, String ownerName, String email, String NIC, String shopName, String registerNo, String contactNo, String address) {
        this.id = id;
        OwnerName = ownerName;
        this.email = email;
        this.NIC = NIC;
        ShopName = shopName;
        RegisterNo = registerNo;
        ContactNo = contactNo;
        Address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public String getRegisterNo() {
        return RegisterNo;
    }

    public void setRegisterNo(String registerNo) {
        RegisterNo = registerNo;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String toString()
    {
        return OwnerName;
    }
}
