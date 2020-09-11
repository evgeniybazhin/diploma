package com.bsuir.diploma.diploma.controller;

import com.bsuir.diploma.diploma.dao.EmployeeRepository;
import com.bsuir.diploma.diploma.domain.db.Employee;
import com.bsuir.diploma.diploma.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/employees")
@RequiredArgsConstructor
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String getEmployeesPage(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null) {
            List<Employee> employeeList = employeeService.findEmployeeByName(name);
            if (!employeeList.isEmpty()) {
                model.addAttribute("employeeList", employeeList);
            }
        }
        model.addAttribute("employees", employeeRepository.findAll());
        return "/views/admin/employees";
    }
}
