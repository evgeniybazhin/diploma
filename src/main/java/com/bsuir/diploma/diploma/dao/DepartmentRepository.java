package com.bsuir.diploma.diploma.dao;

import com.bsuir.diploma.diploma.domain.db.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
