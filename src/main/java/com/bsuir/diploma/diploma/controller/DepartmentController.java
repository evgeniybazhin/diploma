package com.bsuir.diploma.diploma.controller;

import com.bsuir.diploma.diploma.dao.DepartmentRepository;
import com.bsuir.diploma.diploma.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/department")
@RequiredArgsConstructor
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public String getDepartmentPage(Model model) {
        departmentService.calculateEmployeeCount();
        departmentService.calculateEmployeeSalaryByDepartment();
        model.addAttribute("departments", departmentRepository.findAll());
        return "/views/admin/department";
    }
}
