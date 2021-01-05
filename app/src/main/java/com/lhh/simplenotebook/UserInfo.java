package com.lhh.simplenotebook;

import org.litepal.crud.DataSupport;

public class UserInfo extends DataSupport {
   private Integer uid;
    private String password;
    public Integer getUid() {
        return uid;
    }

    public String getPassword() {
        return password;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
