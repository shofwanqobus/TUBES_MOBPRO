package com.mobileprogramming.tubes_mobpro.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetUser {

    @SerializedName("status") String status;
    @SerializedName("msg") String message;
    @SerializedName("data") List<User> userList;

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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
