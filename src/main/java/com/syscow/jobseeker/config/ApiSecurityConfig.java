package com.syscow.jobseeker.config;

import com.syscow.jobseeker.filter.ApiKeyAuthFilter;
import com.syscow.jobseeker.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.
                antMatcher("/job/**").
                csrf().disable().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilter(apiKeyAuthFilter()).authorizeRequests().anyRequest().authenticated()
        ;
    }

    @Bean
    public ApiKeyAuthFilter apiKeyAuthFilter() {
        ApiKeyAuthFilter filter = new ApiKeyAuthFilter();
        Logger logger = LoggerFactory.getLogger(ApiSecurityConfig.class);
        filter.setAuthenticationManager(authentication -> {
            String principal = (String) authentication.getPrincipal();
            logger.debug(principal);
            if (!userService.isApiKeyValid(principal)) {
                throw new BadCredentialsException("The API key was not valid.");
            }
            authentication.setAuthenticated(true);
            return authentication;
        });
        return filter;
    }
}