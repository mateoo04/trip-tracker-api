package com.mateo.trip_tracker_api.repository;

import com.mateo.trip_tracker_api.api.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    @Query("SELECT SUM(e.amount) FROM Expense e")
    BigDecimal getTotalAmount();
}
