package com.google.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String email;
    private String name;
    private String pictureUrl;
}
