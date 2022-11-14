package com.restaurant;

public class food_item {


    private int image ,quantity;
    private String name,description,price;

    public food_item(int image, String name,String price){
        this.image = image;
        this.name = name;
        this.price=price;
    }
    public food_item(int image, String name,String price,int quantity){
        this.image = image;
        this.name = name;
        this.price=price;
        this.quantity=quantity;
    }
    public food_item(int image, String name,String description,String price){
        this.image = image;
        this.name = name;
        this.description = description;
        this.price=price;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
