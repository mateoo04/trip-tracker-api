package com.mateo.trip_tracker_api.api.controller;

import com.mateo.trip_tracker_api.api.model.Reimbursement;
import com.mateo.trip_tracker_api.service.ReimbursementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reimbursement")
@RequiredArgsConstructor
public class ReimbursementController {
    
    private final ReimbursementService reimbursementService;

    @GetMapping
    public ResponseEntity<List<Reimbursement>> getAllReimbursements() {
        return ResponseEntity.ok(reimbursementService.getAllReimbursements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reimbursement> getReimbursementById(@PathVariable Long id) {
        return ResponseEntity.ok(reimbursementService.getReimbursementById(id));
    }

    @PostMapping
    public ResponseEntity<Reimbursement> saveReimbursement(@RequestBody Reimbursement reimbursement) {
        return ResponseEntity.ok(reimbursementService.saveReimbursement(reimbursement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReimbursement(@PathVariable Long id) {
        reimbursementService.deleteReimbursementById(id);
        return ResponseEntity.noContent().build();
    }
}
