package com.bsuir.diploma.diploma.domain.db.cattle;

import com.bsuir.diploma.diploma.domain.db.Employee;
import com.bsuir.diploma.diploma.domain.db.Farm;
import com.bsuir.diploma.diploma.domain.db.Sex;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
@Table(name = "cow")
public class Cow extends Cattle {
    @Builder
    public Cow(Long id, LocalDate birthday, String historyVaccation, Farm farm, LocalDateTime lastUpdateTime) {
        super(id, birthday, historyVaccation);
        this.farm = farm;
        this.lastUpdateTime = lastUpdateTime;
    }

    @ManyToOne
    private Farm farm;

    @Column(name = "last_update_time")
    private LocalDateTime lastUpdateTime;
}