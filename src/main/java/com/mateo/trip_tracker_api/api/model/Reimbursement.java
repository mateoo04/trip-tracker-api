package com.mateo.trip_tracker_api.api.model;

import com.mateo.trip_tracker_api.api.enums.ReimbursementStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Reimbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "expense_id", nullable = false)
    private Expense expense;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ReimbursementStatus status;

    @Column
    private LocalDate approvalDate;
}
