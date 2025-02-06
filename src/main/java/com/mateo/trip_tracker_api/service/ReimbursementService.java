package com.mateo.trip_tracker_api.service;

import com.mateo.trip_tracker_api.api.model.Expense;
import com.mateo.trip_tracker_api.api.model.Reimbursement;
import com.mateo.trip_tracker_api.exception.DatabaseFetchingException;
import com.mateo.trip_tracker_api.repository.ExpenseRepository;
import com.mateo.trip_tracker_api.repository.ReimbursementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReimbursementService {
    private final ReimbursementRepository reimbursementRepository;
    private final ExpenseRepository expenseRepository;

    public List<Reimbursement> getAllReimbursements() {
        return reimbursementRepository.findAll();
    }

    public Reimbursement getReimbursementById(Long id) {
        return reimbursementRepository.findById(id).orElse(null);
    }

    public Reimbursement saveReimbursement(Reimbursement reimbursement) {
        Expense expense = expenseRepository.findById(reimbursement.getExpense().getId())
                .orElseThrow(()-> new DatabaseFetchingException("Expense not found"));
        reimbursement.setExpense(expense);

        return reimbursementRepository.save(reimbursement);
    }

    public Reimbursement updateReimbursement(Reimbursement reimbursement){
        if(reimbursementRepository.existsById(reimbursement.getId())){
            return reimbursementRepository.save(reimbursement);
        }else throw new DatabaseFetchingException("Reimbursement not found");
    }

    public void deleteReimbursementById(Long id) {
        if(reimbursementRepository.existsById(id)) {
            reimbursementRepository.deleteById(id);
        }else throw new DatabaseFetchingException("Reimbursement not found");
    }
}
