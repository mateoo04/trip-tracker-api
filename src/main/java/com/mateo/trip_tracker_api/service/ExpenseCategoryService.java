package com.mateo.trip_tracker_api.service;

import com.mateo.trip_tracker_api.api.model.ExpenseCategory;
import com.mateo.trip_tracker_api.exception.DatabaseFetchingException;
import com.mateo.trip_tracker_api.repository.ExpenseCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseCategoryService {

    private final ExpenseCategoryRepository expenseCategoryRepository;

    public List<ExpenseCategory> getAllExpenseCategories(){
        return expenseCategoryRepository.findAll();
    }

    public ExpenseCategory getExpenseCategoryById(Long id){
        Optional<ExpenseCategory> expenseCategory = expenseCategoryRepository.findById(id);
        return expenseCategory.orElse(null);
    }

    public ExpenseCategory saveExpenseCategory(ExpenseCategory expenseCategory){
        return expenseCategoryRepository.save(expenseCategory);
    }

    public void deleteExpenseCategoryById(Long id){
        if(expenseCategoryRepository.existsById(id)){
            expenseCategoryRepository.deleteById(id);
        }else throw new DatabaseFetchingException("Expense category not found");
    }
}
