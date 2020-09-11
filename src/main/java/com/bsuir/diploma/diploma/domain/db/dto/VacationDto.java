package com.bsuir.diploma.diploma.domain.db.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VacationDto {
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String fullName;
    private String vacationStatus;
}
