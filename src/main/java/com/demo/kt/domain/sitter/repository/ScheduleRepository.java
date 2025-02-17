package com.demo.kt.domain.sitter.repository;

import com.demo.kt.domain.sitter.model.PetSitterServices;
import com.demo.kt.domain.sitter.model.Schedule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findAllByServices(PetSitterServices petSitterServices);

    void deleteAllByServices(PetSitterServices sitterServices);
}
