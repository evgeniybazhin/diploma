package com.bsuir.diploma.diploma.domain.db.cattle;

import com.bsuir.diploma.diploma.domain.db.Sex;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
@Table(name = "bull")
public class Bull extends Cattle {
    @Builder
    public Bull(Long id, LocalDate birthday, String historyVaccation) {
        super(id, birthday, historyVaccation);
    }
}
