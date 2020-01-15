package com.example.ppkwulab4.model;

public class Person {
    String name;
    String title;
    String place;

    public Person() {
    }

    public Person(String name, String title, String place) {
        this.name = name;
        this.title = title;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
