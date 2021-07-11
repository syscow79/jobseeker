package com.syscow.jobseeker.service.job;

import com.syscow.jobseeker.model.PositionResponse;
import com.syscow.jobseeker.model.adzuna.AdzunaResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AzdunaPositionService implements IPositionService {

    private final RestTemplate restTemplate;

    public AzdunaPositionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<PositionResponse> findByNameAndLocation(String keyWord, String what) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromHttpUrl("https://api.adzuna.com/v1/api/jobs/gb/search/1")
                .queryParam("app_id", "4f5704fb")
                .queryParam("app_key", "948c214a5e4f36a193692262d65d8c9c")
                .queryParam("what", keyWord)
                .queryParam("where", what);

        AdzunaResponse body = restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.GET, httpEntity, AdzunaResponse.class)
                .getBody();

        if (body == null || body.getCount() == null || body.getCount().equals(0)) {
            return new ArrayList<>();
        }
        return body.getResults().stream()
                .map(p -> new PositionResponse(
                        p.getTitle(),
                        p.getLocation().getDisplayName(),
                        p.getRedirectUrl()))
                .collect(Collectors.toList());
    }
}
