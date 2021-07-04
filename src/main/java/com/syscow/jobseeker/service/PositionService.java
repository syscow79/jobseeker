package com.syscow.jobseeker.service;

import com.syscow.jobseeker.entity.Position;
import com.syscow.jobseeker.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Integer save(Position position) {
        try {
            return positionRepository.save(position).getId();
        } catch (Exception ex) {
            throw new RuntimeException("Position not created");
        }
    }

    public Position findById(Integer id) {
        Optional<Position> position = positionRepository.findById(id);
        if (position.isEmpty()) {
            throw new RuntimeException("Position not found");
        }
        return position.get();
    }

}
