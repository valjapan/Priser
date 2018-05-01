package com.valjapan.priser.Data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MotionTime extends RealmObject {
    @PrimaryKey
    private Integer sessionId;
    public Long startTime;
    public Long stopTime;

    public MotionTime(){

    }

    public MotionTime(Integer sessionId, Long startTime,Long stopTime){
        this.sessionId = sessionId;
        this.startTime = startTime;
        this.stopTime = stopTime;
    }

//    public void setStartTime(Long startTime) {
//        this.startTime = startTime;
//    }
//
//    public Long getStartTime() {
//        return startTime;
//    }
//
//    public void setStopTime(Long stopTime) {
//        this.stopTime = stopTime;
//    }
//
//    public Long getStopTime() {
//        return stopTime;
//    }
//
//    public int getSessionId() {
//        return sessionId;
//    }
//
//    public void setSessionId(int sessionId) {
//        this.sessionId = sessionId;
//    }
}
