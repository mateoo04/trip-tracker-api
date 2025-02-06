package com.mateo.trip_tracker_api.api.controller;

import com.mateo.trip_tracker_api.api.model.TravelLog;
import com.mateo.trip_tracker_api.service.TravelLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travel-log")
@RequiredArgsConstructor
public class TravelLogController {
    
    private final TravelLogService travelLogService;

    @GetMapping
    public ResponseEntity<List<TravelLog>> getAllTravelLogs() {
        return ResponseEntity.ok(travelLogService.getAllTravelLogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelLog> getTravelLogById(@PathVariable Long id) {
        return ResponseEntity.ok(travelLogService.getTravelLogById(id));
    }

    @PostMapping
    public ResponseEntity<TravelLog> saveTravelLog(@RequestBody TravelLog travelLog) {
        return ResponseEntity.ok(travelLogService.saveTravelLog(travelLog));
    }

    @PutMapping
    public ResponseEntity<TravelLog> updateTravelLog(@RequestBody TravelLog travelLog) {
        return ResponseEntity.ok(travelLogService.updateTravelLog(travelLog));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTravelLog(@PathVariable Long id) {
        travelLogService.deleteTravelLogById(id);
        return ResponseEntity.noContent().build();
    }
}
