package com.example.ferdinand.travelup.model;

public class RestoModel {

    // RestoModel is a class model which contains properties of each place
    private String nameResto, restoAddress, restoReviews;
    private double restoLatitude, restoLongitude;
    private int restoThumbnail;

    // RestoModel constructor is used to input elements for every item in lstResto ArrayList
    public RestoModel(String nameResto, String restoAddress, double restoLatitude, double restoLongitude, String restoReviews, int restoThumbnail) {
        this.nameResto = nameResto;
        this.restoAddress = restoAddress;
        this.restoReviews = restoReviews;
        this.restoLatitude = restoLatitude;
        this.restoLongitude = restoLongitude;
        this.restoThumbnail = restoThumbnail;
    }

    public String getNameResto() {
        return nameResto;
    }

    public String getRestoAddress() {
        return restoAddress;
    }

    public String getRestoReviews() {
        return restoReviews;
    }

    public double getRestoLatitude() {
        return restoLatitude;
    }

    public double getRestoLongitude() {
        return restoLongitude;
    }

    public int getRestoThumbnail() {
        return restoThumbnail;
    }
}
