package com.mateo.trip_tracker_api.service;

import com.mateo.trip_tracker_api.api.model.Employee;
import com.mateo.trip_tracker_api.api.model.Expense;
import com.mateo.trip_tracker_api.api.model.ExpenseCategory;
import com.mateo.trip_tracker_api.api.model.TravelLog;
import com.mateo.trip_tracker_api.exception.DatabaseFetchingException;
import com.mateo.trip_tracker_api.repository.ExpenseCategoryRepository;
import com.mateo.trip_tracker_api.repository.ExpenseRepository;
import com.mateo.trip_tracker_api.repository.TravelLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    
    private final ExpenseRepository expenseRepository;
    private final TravelLogRepository travelLogRepository;
    private final ExpenseCategoryRepository expenseCategoryRepository;

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id){
        Optional<Expense> expenseCategory = expenseRepository.findById(id);
        return expenseCategory.orElse(null);
    }

    public Expense saveExpense(Expense expense){
        TravelLog travelLog = travelLogRepository.findById(expense.getTravelLog().getId())
                .orElseThrow(()-> new DatabaseFetchingException("Travel log not found"));
        expense.setTravelLog(travelLog);
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(expense.getCategory().getId())
                .orElseThrow(()-> new DatabaseFetchingException("Expense category not found"));
        expense.setCategory(expenseCategory);

        return expenseRepository.save(expense);
    }

    public void deleteExpenseById(Long id){
        if(expenseRepository.existsById(id)){
            expenseRepository.deleteById(id);
        }else throw new DatabaseFetchingException("Expense not found");
    }
}
