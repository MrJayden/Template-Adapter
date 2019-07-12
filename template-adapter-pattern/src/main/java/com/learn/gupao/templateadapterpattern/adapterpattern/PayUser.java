package com.learn.gupao.templateadapterpattern.adapterpattern;

public class PayUser extends TransferPayAdapter{

    private String ownAccount;

    private String oppositeAccount;

    private Long tradeAmount;

    private PayUser(){};
    public PayUser(String ownAccount,String oppositeAccount,Long tradeAmount){
        this.ownAccount = ownAccount;
        this.oppositeAccount = oppositeAccount;
        this.tradeAmount = tradeAmount;
    }

    public void doTrade(){
        super.transferTrade(ownAccount,oppositeAccount,tradeAmount);
    }
}
