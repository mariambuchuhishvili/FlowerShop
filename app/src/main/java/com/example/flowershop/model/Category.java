package com.example.flowershop.model;

public class Category {
    //описание категории
    int id;
    String category_title;

     public Category(int id, String category_title){
        this.id=id;
        this.category_title=category_title;
    }

    public int getId() {
        return id;
    }

    public String getCategory_title() {
        return category_title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory_title(String category_title) {
        this.category_title = category_title;
    }
}
