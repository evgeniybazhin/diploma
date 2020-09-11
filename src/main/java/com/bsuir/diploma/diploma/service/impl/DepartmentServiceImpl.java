package com.bsuir.diploma.diploma.service.impl;

import com.bsuir.diploma.diploma.dao.DepartmentRepository;
import com.bsuir.diploma.diploma.dao.EmployeeRepository;
import com.bsuir.diploma.diploma.domain.db.Department;
import com.bsuir.diploma.diploma.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void calculateEmployeeCount() {
        List<Department> listToUpdate = new ArrayList<>();
        for (Department department : departmentRepository.findAll()) {
            Integer employees = employeeRepository.countAllByDepartmentId(department);
            if (employees == null || employees == 0) {
                department.setEmployeeCount(0);
                listToUpdate.add(department);
            } else {
                department.setEmployeeCount(employees);
                listToUpdate.add(department);
            }
        }
        departmentRepository.saveAll(listToUpdate);
    }

    @Override
    public void calculateEmployeeSalaryByDepartment() {
        List<Department> listToUpdate = new ArrayList<>();
        for (Department department : departmentRepository.findAll()) {
            Double salary = employeeRepository.calculateSumSalaryByDepartment(department);
            if (salary == null || salary == 0) {
                department.setSalary((double) 0);
                listToUpdate.add(department);
            } else {
                department.setSalary(salary);
                listToUpdate.add(department);
            }
        }
        departmentRepository.saveAll(listToUpdate);
    }
}
