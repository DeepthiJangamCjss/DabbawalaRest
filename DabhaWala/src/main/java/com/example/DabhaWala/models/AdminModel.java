package com.example.DabhaWala.models;

import org.springframework.stereotype.Component;

@Component
public class AdminModel {
    private String username;
    private String password;
    public AdminModel(){
        username="admin";
        password="admin";
    }

    @Override
    public String toString() {
        return "AdminModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
