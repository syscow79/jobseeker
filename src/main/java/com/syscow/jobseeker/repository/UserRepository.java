package com.syscow.jobseeker.repository;

import com.syscow.jobseeker.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.name = :name")
    Collection<User> findName(@Param("name") String name);

}
