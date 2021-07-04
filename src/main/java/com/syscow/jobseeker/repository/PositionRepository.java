package com.syscow.jobseeker.repository;

import com.syscow.jobseeker.entity.Position;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PositionRepository extends CrudRepository<Position, Integer> {
    @Query("SELECT p FROM Position p WHERE p.name like :keyWord% and p.address like :location%")
    List<Position> findByNameAndLocation(String keyWord, String location);
}
