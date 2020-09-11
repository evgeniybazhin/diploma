package com.bsuir.diploma.diploma.domain.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "vacation")
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_from")
    public LocalDate dateFrom;

    private String test;

    @Column(name =  "date_to")
    public LocalDate dateTo;

    @Enumerated(EnumType.STRING)
    private VacationStatus vacationStatus;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
