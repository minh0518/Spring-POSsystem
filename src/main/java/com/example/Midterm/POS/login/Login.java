package com.example.Midterm.POS.login;


import java.util.Scanner;

public class Login {

    private String id;
    private int password;

    public Login(String id,int password) {
        this.id=id;
        this.password=password;
    }


    public Boolean checkAccount() {
        if (id.equals("minho") && password == 123) {
            return true;
        } else {
            return false;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}

