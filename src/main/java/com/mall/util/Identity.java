package com.mall.util;

/**
 * Created by Jayson on 2014/8/10.
 */
public enum Identity {
    user("user"),
    admin("admin");
    private String identity;

    Identity(String identity) {
        this.identity = identity;
    }

    public String getIdentity() {
        return identity;
    }
}
