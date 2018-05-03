package com.valjapan.priser.Data;

import io.realm.RealmObject;

public class CpuMessage extends RealmObject {
    private String time;
    private String detail;

    public void setCharaTime(String time) {
        this.time = time;
    }


    public String getCharaTime() {
        return time;
    }


    public void setCharaDetail(String detail) {
        this.detail = detail;

    }

    public String getCharaDetail() {
        return detail;

    }

}
