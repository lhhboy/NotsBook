package com.lhh.simplenotebook;

import org.litepal.crud.DataSupport;

public class UserInfo extends DataSupport {
   private int uid;
    private String password;
    public int getUid() {
        return uid;
    }

    public String getPassword() {
        return password;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
