package com.learn.gupao.templateadapterpattern.adapterpattern;

public class TransferAdapterMainTest {
    public static void main(String[] args) {
        w2aTransfer();
    }

    public static void w2aTransfer(){
        PayUser wUser = new PayUser("W10001","A10001",234L);
        wUser.doTrade();
    }
}
