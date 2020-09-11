package com.bsuir.diploma.diploma.domain.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "salary")
    private Double salary;

    @Enumerated(EnumType.STRING)
    private DepartmentEnum departments;

    @OneToMany(mappedBy = "departmentId", fetch = FetchType.LAZY)
    private List<Employee> employees;

    @Column(name = "employee_count")
    private Integer employeeCount;
}
