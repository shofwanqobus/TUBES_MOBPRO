package com.mobileprogramming.tubes_mobpro.Model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id") private String id;
    @SerializedName("name") private String name;
    @SerializedName("username") private String username;
    @SerializedName("password") private String password;
    @SerializedName("photo") private String photo;

    public User() {
    }

    public User(String id, String name, String username, String password, String photo) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
