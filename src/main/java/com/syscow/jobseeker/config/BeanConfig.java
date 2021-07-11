package com.syscow.jobseeker.config;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class BeanConfig {

    @Bean
    public FakeValuesService fakeValuesService() {
        return new FakeValuesService(new Locale("en-GB"), new RandomService());
    }
}