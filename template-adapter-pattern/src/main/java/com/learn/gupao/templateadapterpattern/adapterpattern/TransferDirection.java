package com.learn.gupao.templateadapterpattern.adapterpattern;

public enum TransferDirection {

    IN("转入"),
    OUT("转出"),;

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    TransferDirection(String desc){
        this.desc =desc;
    }
}
