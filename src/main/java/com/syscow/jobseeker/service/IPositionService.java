package com.syscow.jobseeker.service;

import com.syscow.jobseeker.model.PositionResponse;

import java.util.List;

public interface IPositionService {
    List<PositionResponse> findByNameAndLocation(String keyWord, String location);
}
