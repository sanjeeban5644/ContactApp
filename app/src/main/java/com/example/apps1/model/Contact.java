package com.example.apps1.model;

public class Contact {
    private int id;
    private String name;
    private String number;

    public Contact(int id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }
    public Contact(String name,String number){
        this.name = name;
        this.number = number;
    }
    public Contact(){

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
