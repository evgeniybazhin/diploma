package com.bsuir.diploma.diploma.dao;

import com.bsuir.diploma.diploma.domain.db.products.MilkInDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MilkInDayRepository extends JpaRepository<MilkInDay, Long> {
    List<MilkInDay> findAllByDayAfter(LocalDate day);
}
