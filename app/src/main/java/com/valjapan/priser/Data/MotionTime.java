package com.valjapan.priser.Data;

import io.realm.RealmObject;

public class MotionTime extends RealmObject {

    public int totalScore; //何分運動したか


    public MotionTime() {

    }

    public MotionTime(int totalScore) {

        this.totalScore = totalScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}

