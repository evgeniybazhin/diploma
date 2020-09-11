package com.bsuir.diploma.diploma.dao;

import com.bsuir.diploma.diploma.domain.db.products.MilkInDay;
import com.bsuir.diploma.diploma.domain.db.products.MilkInWeek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MilkWeekRepository extends JpaRepository<MilkInWeek, Long> {
}
