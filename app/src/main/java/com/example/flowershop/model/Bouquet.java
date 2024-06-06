package com.example.flowershop.model;

public class Bouquet {
    // описание букета
    int id;
    String name;
    String img;
    String price;
    String color;
    String desciption;
    int[] categoryId;

    public Bouquet(int id, String name, String img, String price, String color, String desciption, int[] categoryId){
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.color = color;
        this.desciption = desciption;
        this.categoryId = categoryId;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDesciption(String desciption) { this.desciption = desciption; }
    public String getDescription()  {   return desciption;    }

    public void setCategoryId(int[] categoryId)   {   this.categoryId = categoryId;   }

    public int[] getCategoryId()  {   return categoryId;  }
}
