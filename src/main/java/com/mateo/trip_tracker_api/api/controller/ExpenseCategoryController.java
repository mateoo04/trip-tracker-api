package com.mateo.trip_tracker_api.api.controller;

import com.mateo.trip_tracker_api.api.model.ExpenseCategory;
import com.mateo.trip_tracker_api.service.ExpenseCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense-category")
@RequiredArgsConstructor
public class ExpenseCategoryController {

    private final ExpenseCategoryService expenseCategoryService;

    @GetMapping
    public ResponseEntity<List<ExpenseCategory>> getAllExpenseCategories() {
        return ResponseEntity.ok(expenseCategoryService.getAllExpenseCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseCategory> getExpenseCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(expenseCategoryService.getExpenseCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<ExpenseCategory> saveExpenseCategory(@RequestBody ExpenseCategory expenseCategory) {
        return ResponseEntity.ok(expenseCategoryService.saveExpenseCategory(expenseCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpenseCategory(@PathVariable Long id) {
        expenseCategoryService.deleteExpenseCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}
