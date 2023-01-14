package com.example.projectrserver.domain.routine.domain.repository;

import com.example.projectrserver.domain.routine.domain.Routine;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoutineRepository extends CrudRepository<Routine, Integer> {
    Optional<Routine> findById(Integer id);
}
