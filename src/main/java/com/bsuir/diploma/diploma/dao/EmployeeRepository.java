package com.bsuir.diploma.diploma.dao;

import com.bsuir.diploma.diploma.domain.db.Department;
import com.bsuir.diploma.diploma.domain.db.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByFirstName(String firstName);
    List<Employee> findByLastName(String lastName);
    List<Employee> findByFullName(String fullName);
    Integer countAllByDepartmentId(Department departmentId);
    @Query(value = "select sum(e.salary) from Employee e where e.departmentId = :department")
    Double calculateSumSalaryByDepartment(Department department);
}
