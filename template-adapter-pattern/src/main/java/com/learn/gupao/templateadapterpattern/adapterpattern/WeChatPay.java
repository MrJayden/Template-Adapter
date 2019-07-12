package com.learn.gupao.templateadapterpattern.adapterpattern;

import java.util.HashMap;
import java.util.Map;

public abstract class WeChatPay {

    public static final Map<String,Long> weChatPayAccount = new HashMap<>();

    abstract boolean weChatPay(Long amount, TransferDirection dirc, String account);

}
