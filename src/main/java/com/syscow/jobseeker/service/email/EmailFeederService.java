package com.syscow.jobseeker.service.email;

import com.syscow.jobseeker.entity.EmailSend;
import com.syscow.jobseeker.repository.EmailSendRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

@Service
public class EmailFeederService {

    private final EmailSendRepository emailSendRepository;
    private final RestTemplate restTemplate;

    public EmailFeederService(EmailSendRepository emailSendRepository, RestTemplate restTemplate) {
        this.emailSendRepository = emailSendRepository;
        this.restTemplate = restTemplate;
    }

    public void feedDatabase(Integer numberOfEmails) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/email/random/" + numberOfEmails)
                .queryParam("APP_KEY", "d237868b-b39e-48a9-8cc2-7e1f08a95b6a");

        String body = restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.GET, httpEntity, String.class)
                .getBody();

        if (body == null) {
            return;
        }
        Arrays.stream(body.split("\\n"))
                .forEach(email -> emailSendRepository.save(EmailSend.builder().email(email).build()));
    }
}
