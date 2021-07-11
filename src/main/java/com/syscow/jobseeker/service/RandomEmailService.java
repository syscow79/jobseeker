package com.syscow.jobseeker.service;

import com.github.javafaker.service.FakeValuesService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RandomEmailService {

    private final FakeValuesService fakeValuesService;

    public RandomEmailService(FakeValuesService fakeValuesService) {
        this.fakeValuesService = fakeValuesService;
    }

    public String generateRandomEmails(Integer id) {
        return Stream.iterate(0, i -> i + 1)
                .parallel().limit(id)
                .map(integer -> fakeValuesService
                        .regexify("[a-z]{2,3}[a-z1-9]{3,9}[@][a-z]{5,7}[.][c][o][m]"))
                .collect(Collectors.joining("\n"));
    }

}
