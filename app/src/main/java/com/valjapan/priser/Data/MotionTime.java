package com.valjapan.priser.Data;

import io.realm.RealmObject;

public class MotionTime extends RealmObject {

    public float totalScore;
    public float resultTime;
    public String nowDate;


    public MotionTime() {

    }

    public MotionTime(float resultTime, float totalScore, String nowDate) {

        this.resultTime = resultTime;
        this.totalScore = totalScore;
        this.nowDate = nowDate;
    }


    public void setResultTime(float resultTime) {
        this.resultTime = resultTime;
    }

    private float getResultTime() {
        return resultTime;
    }

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }

    public String getNowDate() {
        return nowDate;
    }

    public void setNowDate(String nowDate) {
        this.nowDate = nowDate;
    }
}
