package com.food.store.myfoodapp.Model;

/**
 * Created by Moses on 10/23/2017.
 */

public class Beer {
    private String Name;
    private String Image;
    private String Price;
    private String Discount;
    private String MenuId;
    private String Description;

    public Beer() {
    }

    public Beer(String name, String image, String price, String discount, String menuId, String description) {
        Name = name;
        Image = image;
        Price = price;
        Discount = discount;
        MenuId = menuId;
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
