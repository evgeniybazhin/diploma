package com.bsuir.diploma.diploma.dao;

import com.bsuir.diploma.diploma.domain.db.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository extends JpaRepository<Farm, Long> {
    Farm findByLocation(String location);
}
