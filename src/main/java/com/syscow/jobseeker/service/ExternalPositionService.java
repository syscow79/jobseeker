package com.syscow.jobseeker.service;

import com.syscow.jobseeker.model.PositionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExternalPositionService {

    private final List<IPositionService> positionServices;

    @Autowired
    public ExternalPositionService(List<IPositionService> positionServices) {
        this.positionServices = positionServices;
    }

    public List<PositionResponse> findAllByNameAndLocation(String keyWord, String location) {
        List<PositionResponse> positionResponses = new ArrayList<>();
        positionServices.parallelStream().forEach(positionService -> {
            positionResponses.addAll(positionService.findByNameAndLocation(keyWord, location));
        });
        return positionResponses;
    }

}
