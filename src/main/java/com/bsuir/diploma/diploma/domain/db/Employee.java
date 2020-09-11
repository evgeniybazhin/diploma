package com.bsuir.diploma.diploma.domain.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "employment_date")
    private LocalDate employmentDate;

    @Column(name = "salary")
    private Double salary;

    @OneToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "position")
    private String position;

    @Enumerated(EnumType.STRING)
    private ManagerStatus managerStatus;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "deparment_id")
    private Department departmentId;
}
