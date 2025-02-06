package com.mateo.trip_tracker_api.repository;

import com.mateo.trip_tracker_api.api.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
