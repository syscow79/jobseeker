package com.syscow.jobseeker.model;

import lombok.Data;

@Data
public class PositionResponse {

    private String jobTitle;

    private String location;

    private String url;

    public PositionResponse(String name, String address, String url) {
        this.jobTitle = name;
        this.location = address;
        this.url = url;
    }
}
