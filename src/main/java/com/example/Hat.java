package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hat {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String color;

    private int size;

    public Hat(int id, String name, String color, int size) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public Hat() {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
