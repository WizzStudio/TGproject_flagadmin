package com.ctg.flagadmin.pojo.dto;

public class OptionDto <A, B> {
    private A optKey;
    private B optVal;

    public OptionDto() {
    }

    public OptionDto(A key, B val) {
        this.optKey = key;
        this.optVal = val;
    }

    public void setOptKey(A optKey) {
        this.optKey = optKey;
    }

    public void setOptVal(B optVal) {
        this.optVal = optVal;
    }

    public A getOptKey() {
        return optKey;
    }

    public B getOptVal() {
        return optVal;
    }
}
