package com.bsuir.diploma.diploma.domain.db.cattle;

import com.bsuir.diploma.diploma.domain.db.Farm;
import com.bsuir.diploma.diploma.domain.db.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Cattle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "history_vaccination")
    private String historyVaccination;
}
