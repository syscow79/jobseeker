package com.syscow.jobseeker.repository;

import com.syscow.jobseeker.entity.Position;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, Integer> {
}
