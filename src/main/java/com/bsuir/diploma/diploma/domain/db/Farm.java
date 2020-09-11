package com.bsuir.diploma.diploma.domain.db;

import com.bsuir.diploma.diploma.domain.db.cattle.Bull;
import com.bsuir.diploma.diploma.domain.db.cattle.Cow;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "farm")
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "location")
    private String location;

    @OneToMany
    @JoinColumn(name = "farm_id")
    private List<Cow> cows;
}
