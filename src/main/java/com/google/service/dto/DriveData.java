package com.google.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class DriveData {
    private String kind;
    private String nextPageToken;
    private String incompleteSearch;
    private List<Files> files;
}
