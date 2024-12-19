package com.example.demo.controller;

import lombok.Data;

@Data
public class UserIdRequest {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}