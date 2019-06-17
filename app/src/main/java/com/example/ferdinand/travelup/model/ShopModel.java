package com.example.ferdinand.travelup.model;

public class ShopModel {

    // ShopModel is a class model which contains properties of each place
    private String nameShop, shopAddress, shopReviews;
    private double shopLatitude, shopLongitude;
    private int shopThumbnail;

    // ShopModel constructor is used to input elements for every item in lstShop ArrayList
    public ShopModel(String nameShop, String shopAddress, double shopLatitude, double shopLongitude, String shopReviews, int shopThumbnail) {
        this.nameShop = nameShop;
        this.shopAddress = shopAddress;
        this.shopReviews = shopReviews;
        this.shopLatitude = shopLatitude;
        this.shopLongitude = shopLongitude;
        this.shopThumbnail = shopThumbnail;
    }

    public String getNameShop() {
        return nameShop;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public String getShopReviews() {
        return shopReviews;
    }

    public double getShopLatitude() {
        return shopLatitude;
    }

    public double getShopLongitude() {
        return shopLongitude;
    }

    public int getShopThumbnail() {
        return shopThumbnail;
    }
}
