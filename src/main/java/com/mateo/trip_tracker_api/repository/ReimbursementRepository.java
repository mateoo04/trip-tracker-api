package com.mateo.trip_tracker_api.repository;

import com.mateo.trip_tracker_api.api.model.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReimbursementRepository extends JpaRepository<Reimbursement, Long> {
}
