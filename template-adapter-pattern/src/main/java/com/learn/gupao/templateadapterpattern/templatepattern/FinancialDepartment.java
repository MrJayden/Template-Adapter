package com.learn.gupao.templateadapterpattern.templatepattern;

import java.util.List;
import java.util.Map;

public class FinancialDepartment extends WorkReport {
    private Map<String,Object> param;
    private FinancialDepartment(){};
    public FinancialDepartment(Map<String,Object> param){
        this.param =param;
    }

    @Override
    protected String department() {
        return (String)param.get("dept");
    }

    @Override
    protected String currentWeek() {
        return (String)param.get("week");
    }

    @Override
    protected List<String> workContent() {
        return (List<String>)param.get("workContent");
    }

    @Override
    protected List<String> currentProblems() {
        return (List<String>)param.get("problems");
    }
}
