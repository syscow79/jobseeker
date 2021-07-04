package com.syscow.jobseeker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {
    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @PostMapping(path = "/user")
    public ResponseEntity<String> createUser() {
        return ResponseEntity.ok("Api key");
    }
}
