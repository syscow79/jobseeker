package com.syscow.jobseeker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/job")
public class JobController {

    @PostMapping(path = "/position")
    public ResponseEntity<String> createPosition() {
        return ResponseEntity.ok("url");
    }

}
