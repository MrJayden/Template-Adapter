package com.learn.gupao.templateadapterpattern.templatepattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkReportMainTest {
    public static void main(String[] args) {
        testFinancialDepartment();
    }

    public static void testFinancialDepartment(){
        Map<String,Object> fnParam = new HashMap<>();
        fnParam.put("dept","财务部");
        fnParam.put("week","第21周");
        List<String> fnContent = new ArrayList<>();
        fnContent.add("1、季度审核完成");
        fnContent.add("2、工资发放完成");
        fnContent.add("3、财务账目核对完成");
        fnParam.put("workContent",fnContent);
        List<String> problems = new ArrayList<>();
        problems.add("1、老板和财务经理有一腿");
        problems.add("2、财务经理携款潜逃了");
        fnParam.put("problems",problems);
        FinancialDepartment fdept = new FinancialDepartment(fnParam);
        fdept.createWorkReport();
    }

    public static void testItDeptment(){
        Map<String,Object> itParam = new HashMap<>();
        Map<String,Object> extParam = new HashMap<>();
        itParam.put("dept","研发三部");
        itParam.put("week","第45周");
        List<String> itContent = new ArrayList<>();
        itContent.add("1、系统环境搭建");
        itContent.add("2、调试war包");
        itContent.add("3、测试项目功能");
        itContent.add("4、开发功能");
        itContent.add("5、自我能力提升");
        List<String> itProblem = new ArrayList<>();
        itProblem.add("1、反馈慢");
        itProblem.add("2、不注重细节");
        itParam.put("workContent",itContent);
        itParam.put("problems",itProblem);
        ITDepartment itWorkReport = new ITDepartment(itParam);


        extParam.put("finish work",true);
        extParam.put("evaluate","very good");
        List<String> remark = new ArrayList<>();
        remark.add("1、需要购买服务器");
        remark.add("2、要给员工涨工资");
        remark.add("3、妈的，别将嘴当菊花的用，尽放屁了");
        extParam.put("remark",remark);
        itWorkReport.setExtParam(extParam);
        itWorkReport.createWorkReport();
    }
}
