package com.learn.gupao.templateadapterpattern.adapterpattern;

public class TransferAdapterMainTest {
    public static void main(String[] args) {
        w2wTransfer();
    }

    public static void w2aTransfer(){
        PayUser wUser = new PayUser("W1001","A2001",234L);
        wUser.doTrade();
    }

    public static void a2wTransfer(){
        PayUser wUser = new PayUser("A2002","W1002",234L);
        wUser.doTrade();
    }

    public static void a2aTransfer(){
        PayUser wUser = new PayUser("A2001","A2002",234L);
        wUser.doTrade();
    }

    public static void w2wTransfer(){
        PayUser wUser = new PayUser("W1001","W1002",234L);
        wUser.doTrade();
    }
}
