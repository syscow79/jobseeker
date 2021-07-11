package com.syscow.jobseeker.repository;

import com.syscow.jobseeker.entity.JobError;
import org.springframework.data.repository.CrudRepository;

public interface JobErrorResponseRepository extends CrudRepository<JobError, Integer> {
}
