package com.syscow.jobseeker.controller;

import com.syscow.jobseeker.service.RandomEmailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/random")
public class RandomController {

    private final RandomEmailService randomEmailService;

    public RandomController(RandomEmailService randomEmailService) {
        this.randomEmailService = randomEmailService;
    }

    @GetMapping(path = "/mails/{id}")
    public String generateEmails(@PathVariable Integer id) {
        return randomEmailService.generateRandomEmails(id);
    }

}
