package com.syscow.jobseeker.controller;

import com.syscow.jobseeker.entity.Position;
import com.syscow.jobseeker.repository.PositionRepository;
import com.syscow.jobseeker.service.PositionService;
import com.syscow.jobseeker.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/job")
public class JobController {

    private final PositionService positionService;

    public JobController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping(path = "/position")
    public ResponseEntity<String> createPosition(@Valid @RequestBody Position position) {
        try {
            Integer id = positionService.save(position);
            final String url = ServletUriComponentsBuilder.fromCurrentRequestUri()
                    .build().toUriString();
            return ResponseEntity.ok(url + "/" + id);
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }

    @GetMapping(path = "/position/{id}")
    public ResponseEntity<Position> findPosition(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(positionService.findById(id));
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Foo Not Found", ex);
        }
    }

}
