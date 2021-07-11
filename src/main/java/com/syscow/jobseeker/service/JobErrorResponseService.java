package com.syscow.jobseeker.service;

import com.syscow.jobseeker.entity.JobError;
import com.syscow.jobseeker.exception.RepositoryException;
import com.syscow.jobseeker.model.JobErrorResponse;
import com.syscow.jobseeker.repository.JobErrorResponseRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JobErrorResponseService {

    private final JobErrorResponseRepository jobErrorResponseRepository;

    public JobErrorResponseService(JobErrorResponseRepository jobErrorResponseRepository) {
        this.jobErrorResponseRepository = jobErrorResponseRepository;
    }

    public JobErrorResponse save(Exception ex, List<String> messages) {
        JobError jobError = jobErrorResponseRepository.save(JobError.builder()
                .date(new Date())
                .exception(ex.toString())
                .messages(String.join(", ", messages))
                .build()
        );
        return JobErrorResponse.builder()
                .id(jobError.getId())
                .date(jobError.getDate())
                .messages(jobError.getMessages())
                .build();
    }

    public JobErrorResponse save(Exception ex) {
        JobError jobError = jobErrorResponseRepository.save(JobError.builder()
                .date(new Date())
                .exception(ex.toString())
                .build());
        return JobErrorResponse.builder()
                .id(jobError.getId())
                .date(jobError.getDate())
                .messages(jobError.getMessages())
                .build();
    }
}
