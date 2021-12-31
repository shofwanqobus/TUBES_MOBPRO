package com.mobileprogramming.tubes_mobpro.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetReview {
    @SerializedName("status") String status;
    @SerializedName("msg") String message;
    @SerializedName("data") List<Review> reviewList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
