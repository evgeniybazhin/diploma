package com.bsuir.diploma.diploma.service.impl;

import com.bsuir.diploma.diploma.dao.EmployeeRepository;
import com.bsuir.diploma.diploma.domain.db.Employee;
import com.bsuir.diploma.diploma.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findEmployeeByName(String name) {
        List<Employee> optionalList = employeeRepository.findByFirstName(name);
        if (!optionalList.isEmpty()) {
            return optionalList;
        }
        optionalList = employeeRepository.findByLastName(name);
        if (!optionalList.isEmpty()) {
            return optionalList;
        }
        optionalList = employeeRepository.findByFullName(name);
        if (!optionalList.isEmpty()) {
            return optionalList;
        }
        return Collections.emptyList();
    }
}
