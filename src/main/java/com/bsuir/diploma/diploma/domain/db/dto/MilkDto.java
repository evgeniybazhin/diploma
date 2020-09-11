package com.bsuir.diploma.diploma.domain.db.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MilkDto {
    private Long id;
    private Double countOfMilk;
}
