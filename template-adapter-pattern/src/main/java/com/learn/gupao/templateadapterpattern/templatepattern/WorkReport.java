package com.learn.gupao.templateadapterpattern.templatepattern;

import org.springframework.util.StringUtils;

import java.util.List;

public abstract class WorkReport {

    protected abstract String department();

    protected abstract String currentWeek() ;

    protected abstract List<String> workContent();

    protected abstract List<String> currentProblems();

    protected boolean isFunction(){return false;};

    public void extFunction(){};

    public final void createWorkReport(){
        System.out.println("************<< ※      部门工作信息      ※ >>************");
        doublePartLine();
        partLine();
        notListPrintln("department",department());
        partLine();
        notListPrintln("week",currentWeek());
        partLine();
        listPrintln("work contents",workContent());
        partLine();
        listPrintln("problems",currentProblems());
        if(isFunction()){
            partLine();
            extFunction();
        }
        doublePartLine();
    }


    public final void notListPrintln(String title,Object content){
        title = replaceContentLength(title);
        System.out.println(title+"  "+content.toString());
    };

    public final void listPrintln(String title,List<String> lists){
        title = replaceContentLength(title);
        int count = lists.size();
        if(count == 0){
            System.out.println(title);
            return;
        }
        int titlecol = count/2+((count%2==0?-1:0));
        for(int i=0;i<count;i++){
            if(i==titlecol){
                System.out.println(title+"  "+lists.get(i));
            }else{
                System.out.println(replaceContentLength(null)+"  "+lists.get(i));
            }
        }
    };

    public final void doublePartLine(){
        System.out.println("========================================================");
    }

    public final void partLine(){
        System.out.println("|------------------------------------------------------");
    }

    public final String replaceContentLength(String title){
     if(StringUtils.isEmpty(title)){
         return "|                  |";
     }
     int charCount = title.length();
     if(charCount>16){
        return "|  "+String.copyValueOf(title.toCharArray(),0,15)+"**|";
     }else{
        return "|  "+title+getFalgs(" ",16-charCount)+"|";
     }
    }

    private String getFalgs(String flag,int count){
        String flags = "";
        if(count>0 && !StringUtils.isEmpty(flag)){
            for(int i=0;i<count;i++){
                flags+=flag;
            }
        }
        return flags;
    }
}
