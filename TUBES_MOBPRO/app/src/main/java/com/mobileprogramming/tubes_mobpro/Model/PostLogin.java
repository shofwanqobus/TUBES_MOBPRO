package com.mobileprogramming.tubes_mobpro.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostLogin {

    @SerializedName("status") String status;
    @SerializedName("msg") String msg;
    @SerializedName("data") List<User> userList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
