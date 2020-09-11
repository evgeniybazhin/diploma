package com.bsuir.diploma.diploma.service;

import com.bsuir.diploma.diploma.domain.db.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findEmployeeByName(String name);

}
