package com.bsuir.diploma.diploma.dao;

import com.bsuir.diploma.diploma.domain.db.Vacation;
import com.bsuir.diploma.diploma.domain.db.VacationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
    List<Vacation> findAllByVacationStatus(VacationStatus vacationStatus);
}
