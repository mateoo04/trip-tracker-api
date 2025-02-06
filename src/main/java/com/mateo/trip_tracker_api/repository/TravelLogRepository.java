package com.mateo.trip_tracker_api.repository;

import com.mateo.trip_tracker_api.api.model.TravelLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelLogRepository extends JpaRepository<TravelLog, Long> {
}
