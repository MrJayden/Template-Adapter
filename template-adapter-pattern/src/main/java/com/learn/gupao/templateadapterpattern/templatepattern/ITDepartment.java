package com.learn.gupao.templateadapterpattern.templatepattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ITDepartment extends WorkReport {
    private Map<String,Object> param = null;
    private Map<String,Object> extParam = null;
    private boolean isExtFunction = false;
    private ITDepartment(){};
    public ITDepartment(Map<String,Object> param){
     this.param =param;
    }

    public ITDepartment setExtParam(Map<String,Object> extParam){
        if(extParam.size()>0){
            isExtFunction = true;
            this.extParam = extParam;
        }
         return this;
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

    @Override
    protected boolean isFunction() {
        return isExtFunction;
    }

    @Override
    public void extFunction() {
        if(extParam != null && extParam.size()>0){
           extParam.forEach((key,ct)->{
               if(ct instanceof ArrayList){
                    listPrintln(key,(List<String>)ct);
                }else if(ct instanceof Boolean){
                    notListPrintln(key,(Boolean)ct?"yes":"no");
                }else if(ct instanceof String){
                    notListPrintln(key,ct);
                }
               partLine();
           });

        }
    }


}
