package com.mateo.trip_tracker_api.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ExpenseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
}

