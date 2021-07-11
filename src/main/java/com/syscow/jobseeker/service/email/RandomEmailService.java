package com.syscow.jobseeker.service.email;

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
                        .regexify("[a-z]{1}[a-z1-9]{1}[@][a-z]{1}[.][c][o][m]"))
                .collect(Collectors.joining("\n"));
    }

}
