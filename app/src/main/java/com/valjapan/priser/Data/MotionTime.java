package com.valjapan.priser.Data;

import io.realm.RealmObject;

public class MotionTime extends RealmObject {
    public Long startTime;
    public Long stopTime;
    public Long resultTime;


    public MotionTime() {

    }

    public MotionTime(Long startTime, Long stopTime, Long resultTime) {
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.resultTime = resultTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStopTime(Long stopTime) {
        this.stopTime = stopTime;
    }

    public Long getStopTime() {
        return stopTime;
    }

    public void setResultTime(Long resultTime) {
        this.resultTime = resultTime;
    }

    private Long getResultTime() {
        return resultTime;
    }
}
