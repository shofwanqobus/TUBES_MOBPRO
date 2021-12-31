package com.mobileprogramming.tubes_mobpro.Model;

import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("id") private String id;
    @SerializedName("user_id") private String userId;
    @SerializedName("nama_tempat") private String namaTempat;
    @SerializedName("rating") private String rating;
    @SerializedName("comment") private String comment;
    @SerializedName("trip_id") private String trip_id;

    public Review() {
    }

    public Review(String id, String userId, String namaTempat, String rating, String comment, String trip_id) {
        this.id = id;
        this.userId = userId;
        this.namaTempat = namaTempat;
        this.rating = rating;
        this.comment = comment;
        this.trip_id = trip_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNamaTempat() {
        return namaTempat;
    }

    public void setNamaTempat(String namaTempat) {
        this.namaTempat = namaTempat;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }
}
