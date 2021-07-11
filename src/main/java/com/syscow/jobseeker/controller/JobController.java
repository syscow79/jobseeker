package com.syscow.jobseeker.controller;

import com.syscow.jobseeker.entity.Position;
import com.syscow.jobseeker.model.PositionResponse;
import com.syscow.jobseeker.service.ExternalPositionService;
import com.syscow.jobseeker.service.PositionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping(path = "/job")
@Validated
public class JobController {

    private final PositionService positionService;
    private final ExternalPositionService externalPositionService;

    public JobController(PositionService positionService, ExternalPositionService externalPositionService) {
        this.positionService = positionService;
        this.externalPositionService = externalPositionService;
    }

    @PostMapping(path = "/position")
    public String createPosition(@Valid @RequestBody Position position) {
        return getFindUri(positionService.save(position));
    }

    private String getFindUri(Integer id) {
        final String url = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .build().toUriString();
        return url + "/" + id;
    }

    @GetMapping(path = "/position/{id}")
    public Position findPosition(@PathVariable Integer id) {
        return positionService.findById(id);
    }

    @GetMapping(path = "/positions")
    public List<PositionResponse> findPositions(
            @RequestParam("keyword") @Size(min = 5, max = 50) String keyWord,
            @RequestParam("location") @Size(min = 5, max = 50) String location) {
        return externalPositionService.findAllByNameAndLocation(keyWord, location);
    }

}
