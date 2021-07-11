package com.syscow.jobseeker.service;

import com.syscow.jobseeker.entity.Position;
import com.syscow.jobseeker.exception.RepositoryException;
import com.syscow.jobseeker.exception.RepositoryNotFoundException;
import com.syscow.jobseeker.model.PositionResponse;
import com.syscow.jobseeker.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PositionService implements IPositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Integer save(Position position) {
        try {
            return positionRepository.save(position).getId();
        } catch (Exception ex) {
            throw new RepositoryException("Position not created", ex);
        }
    }

    public Position findById(Integer id) {
        Optional<Position> position = positionRepository.findById(id);
        if (position.isEmpty()) {
            throw new RepositoryNotFoundException("Position not found");
        }
        return position.get();
    }

    public List<PositionResponse> findByNameAndLocation(String keyWord, String location) {
        List<Position> result = positionRepository.findByNameAndLocation(keyWord, location);
//        final String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri()
//                .build().toUriString();
        String baseUrl = "http://localhost:8080/job/positions";
        final String url = baseUrl.substring(0, baseUrl.length() - 1) + "/";
        return result.stream().map(p -> new PositionResponse(p.getName(), p.getAddress(), url + p.getId()))
                .collect(Collectors.toList());
    }

}
