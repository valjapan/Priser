package com.valjapan.priser.Data;

import io.realm.RealmObject;

public class UserMessage extends RealmObject {
    private String time;
    private String detail;

    public void setSelfTime(String time) {
        this.time = time;
    }


    public String getSelfTime() {
        return time;
    }


    public void setSelfDetail(String detail) {
        this.detail = detail;

    }

    public String getSelfDetail() {
        return detail;

    }

}

