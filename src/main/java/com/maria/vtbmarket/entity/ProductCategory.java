package com.maria.vtbmarket.entity;

import java.util.List;

public class ProductCategory {

    private int id;
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
}
