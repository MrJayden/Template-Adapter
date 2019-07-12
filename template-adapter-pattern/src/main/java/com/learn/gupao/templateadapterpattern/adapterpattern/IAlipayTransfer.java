package com.learn.gupao.templateadapterpattern.adapterpattern;

import java.util.HashMap;
import java.util.Map;

public interface IAlipayTransfer {

    public static final Map<String,Long> aliPayAccounts = new HashMap<>();

    boolean alipayTrade(Long amount, TransferDirection dirc, String account);
}
