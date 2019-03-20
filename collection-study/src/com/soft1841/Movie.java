package com.soft1841;

public class Movie {
    private Integer id;
    private String name;
    private Double price;

    public Movie(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Movie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "  " + price ;
    }
}
