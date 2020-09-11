package com.bsuir.diploma.diploma.domain.db.products;

import com.bsuir.diploma.diploma.domain.db.cattle.Cow;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "milk")
public class Milk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "count")
    private Double count;

    @CreationTimestamp
    private LocalDateTime creationTime;

    @ManyToOne
    private Cow cowId;
}
