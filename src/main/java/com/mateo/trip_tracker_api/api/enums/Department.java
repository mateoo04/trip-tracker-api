package com.mateo.trip_tracker_api.api.enums;

public enum Department {
    HUMAN_RESOURCES("Human Resources Department"),
    MARKETING_AND_SALES("Marketing and Sales Department"),
    ACCOUNTING_AND_FINANCE("Accounting and Finance Department"),
    PRODUCTION("Production Department"),
    RESEARCH_AND_DEVELOPMENT("Research and Development Department"),
    IT("IT Department"),
    CUSTOMER_SERVICE("Customer Service Department"),
    OPERATIONS_MANAGER("Operations Management Department");

    private final String name;

    Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

