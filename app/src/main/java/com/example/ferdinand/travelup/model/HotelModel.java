package com.example.ferdinand.travelup.model;

public class HotelModel {

    // HotelModel is a class model which contains properties of each place
    private String nameHotel, hotelAddress, hotelReviews;
    private double hotelLatitude, hotelLongitude;
    private int hotelThumbnail;

    // HotelModel constructor is used to input elements for every item in lstHotel ArrayList
    public HotelModel(String nameHotel, String hotelAddress, double hotelLatitude, double hotelLongitude, String hotelReviews, int hotelThumbnail){
        this.nameHotel = nameHotel;
        this.hotelAddress = hotelAddress;
        this.hotelLatitude = hotelLatitude;
        this.hotelLongitude = hotelLongitude;
        this.hotelReviews = hotelReviews;
        this.hotelThumbnail = hotelThumbnail;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public int getHotelThumbnail() {
        return hotelThumbnail;
    }

    public double getHotelLatitude() {
        return hotelLatitude;
    }

    public double getHotelLongitude() {
        return hotelLongitude;
    }

    public String getHotelReviews() {
        return hotelReviews;
    }
}
