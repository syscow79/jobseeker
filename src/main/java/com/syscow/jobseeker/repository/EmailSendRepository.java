package com.syscow.jobseeker.repository;

import com.syscow.jobseeker.entity.EmailSend;
import com.syscow.jobseeker.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface EmailSendRepository extends CrudRepository<EmailSend, Integer> {
}
