package com.riwi.pruebaRiwi.domain.model;

import com.riwi.pruebaRiwi.util.enums.StatusLoad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class LoadEntity extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer weight;

    @Column(nullable = false)
    private Integer dimension;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusLoad status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "palet_id")
    private Palet palet;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
