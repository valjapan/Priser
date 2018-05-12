package com.valjapan.priser.Data;

import io.realm.RealmObject;

public class MotionTime extends RealmObject {

    public String resultTime;
    public String nowTime;


    public MotionTime() {

    }

    public MotionTime(String nowTime, String resultTime) {
        this.nowTime = nowTime;
        this.resultTime = resultTime;
    }

    public void setNowTime(String nowTime) {
        this.nowTime = nowTime;
    }

    private String getNowTime() {
        return nowTime;
    }

    public void setResultTime(String resultTime) {
        this.resultTime = resultTime;
    }

    private String getResultTime() {
        return resultTime;
    }
}
