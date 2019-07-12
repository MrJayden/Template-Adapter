package com.learn.gupao.templateadapterpattern.adapterpattern;

import java.util.Map;


public class TransferPayAdapter extends WeChatPay implements IAlipayTransfer {

    static{
        WeChatPay.weChatPayAccount.put("W1001",200000000L);
        WeChatPay.weChatPayAccount.put("W1002",300000000L);
        WeChatPay.weChatPayAccount.put("W1003",400000000L);

        IAlipayTransfer.aliPayAccounts.put("A2001",3000000L);
        IAlipayTransfer.aliPayAccounts.put("A2002",2000000L);
        IAlipayTransfer.aliPayAccounts.put("A2003",1000000L);
    }

    /**
     * 支付宝账号前缀
     */
    private static final String ALIPAY_ACCOUNT_PREFIX = "A";
    /**
     * 微信账号前缀
     */
    private static final String WECHAT_ACCOUNT_PREFIX = "W";

    /**
     * 支付宝支付
     * @param amount  交易金额
     * @param dirc    交易方向
     * @param account 交易账号
     * @return        是否交易成功
     */
    @Override
    public boolean alipayTrade(Long amount, TransferDirection dirc, String account) {
        return accountTrade(aliPayAccounts,amount,dirc,account);
    }

    /**
     * 微信支付
     * @param amount  交易金额
     * @param dirc    交易方向
     * @param account 交易账号
     * @return        是否交易成功
     */
    @Override
    public boolean weChatPay(Long amount, TransferDirection dirc, String account) {
        return accountTrade(weChatPayAccount,amount,dirc,account);
    }

    /**
     * 账户交易
     * @param typeAccounts   交易方账户类型，支付宝账户，微信账户
     * @param amount   交易金额
     * @param dirc     交易方向
     * @param account  交易账户
     */
    private boolean accountTrade(Map<String,Long> typeAccounts,Long amount,TransferDirection dirc,String account){
        if(TransferDirection.OUT == dirc){
            amount = -amount;
        }
        typeAccounts.put(account,typeAccounts.get(account)+amount);
        return true;
    }

    public boolean transferTrade(String outAccount,String inAccount,Long tradeAmount){
        System.out.println("***********************交易前支付宝账户： "+aliPayAccounts);
        System.out.println("***********************交易前微信账户： "+weChatPayAccount);
        doAccountTrade(outAccount,tradeAmount,TransferDirection.OUT);
        doAccountTrade(inAccount,tradeAmount,TransferDirection.IN);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@交易后支付宝账户： "+aliPayAccounts);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@交易后微信账户： "+weChatPayAccount);
        return true;
    }
    /***
     * 转出方账号进行扣款
     * @param account  转出方账号
     * @param tradeAmount 交易金额
     * @return 是否执行成功
     */
    private boolean doAccountTrade(String account,Long tradeAmount,TransferDirection dirc){
        Map<String, Long> typeAccount = getTradeTypeAccount(account);
        checkAmountOfAccount(typeAccount,tradeAmount,account,dirc);
        if(account.startsWith(ALIPAY_ACCOUNT_PREFIX)){
            alipayTrade(tradeAmount,dirc,account);
        }else if(account.startsWith(WECHAT_ACCOUNT_PREFIX)){
            weChatPay(tradeAmount,dirc,account);
        }
        return true;
    }

    /**
     * 获取交易类型账户
     * @param account  交易账号
     * @return
     */
     private Map<String,Long> getTradeTypeAccount(String account){
         if(account.startsWith(ALIPAY_ACCOUNT_PREFIX)){
             return aliPayAccounts;
         }else if(account.startsWith(WECHAT_ACCOUNT_PREFIX)){
             return weChatPayAccount;
         }else{
             throw new RuntimeException("不存在此类账号【"+account+"】");
         }
     }

    /**
     * 校验账户余额
     * @param accounts 交易方账户类型，支付宝账户，微信账户
     * @param amount   交易金额
     * @param account  交易账户
     */
    private void checkAmountOfAccount(Map<String,Long> accounts, Long amount, String account, TransferDirection dire){
        Long balance = accounts.get(account);
        if(balance == null){
            throw new RuntimeException("账户【"+account+"】不存在");
        }else if(TransferDirection.OUT == dire && balance<amount){
            throw new RuntimeException("账户【"+account+"】余额不足");
        }
    }

}
