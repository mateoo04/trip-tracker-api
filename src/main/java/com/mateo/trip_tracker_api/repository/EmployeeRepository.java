package com.mateo.trip_tracker_api.repository;

import com.mateo.trip_tracker_api.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
