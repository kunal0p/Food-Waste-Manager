package com.example.foodwastemanager;

public class users {

    String name,food,address,date,contact;

    public users() {
    }

    public users(String name, String food, String address,String date,String contact) {
        this.name = name;
        this.food = food;
        this.address = address;
        this.date = date;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
