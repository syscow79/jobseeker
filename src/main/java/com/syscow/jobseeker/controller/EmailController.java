package com.syscow.jobseeker.controller;

import com.syscow.jobseeker.service.email.EmailFeederService;
import com.syscow.jobseeker.service.email.RandomEmailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/email")
public class EmailController {

    private final RandomEmailService randomEmailService;
    private final EmailFeederService emailFeederService;

    public EmailController(RandomEmailService randomEmailService, EmailFeederService emailFeederService) {
        this.randomEmailService = randomEmailService;
        this.emailFeederService = emailFeederService;
    }

    @GetMapping(path = "/random/{count}")
    public String generateEmails(@PathVariable Integer count) {
        return randomEmailService.generateRandomEmails(count);
    }

    @PostMapping(path = "/feed/{count}")
    public void feedEmails(@PathVariable Integer count) {
        emailFeederService.feedDatabase(count);
    }

}
