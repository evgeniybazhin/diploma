package com.bsuir.diploma.diploma.dao;

import com.bsuir.diploma.diploma.domain.db.cattle.Cow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CowRepository extends JpaRepository<Cow, Long> {
    List<Cow> findAllByBirthdayAfter(LocalDate birthday);
}
