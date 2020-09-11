package com.bsuir.diploma.diploma.dao;

import com.bsuir.diploma.diploma.domain.db.products.Milk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MilkRepository extends JpaRepository<Milk, Long> {
    List<Milk> findAllByCreationTimeAfter(LocalDateTime creationTime);
}
