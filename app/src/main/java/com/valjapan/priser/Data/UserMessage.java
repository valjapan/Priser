package com.valjapan.priser.Data;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;

public class UserMessage extends RealmObject {
    public String userDetail;
    public String userTime;
    public String cpuDetail;
    public String cpuTime;

    public UserMessage() {

    }

    public UserMessage(String userDetail, String userTime, String cpuDetail, String cpuTime){
        this.userDetail = userDetail;
        this.userTime = userTime;
        this.cpuDetail = cpuDetail;
        this.cpuTime = cpuTime;
    }

    public static List<UserMessage> createDummyData(){
        List<UserMessage> dataset = new ArrayList<>();
        dataset.add(new UserMessage("aaa", "bbb", "ccc", "dddd"));
        dataset.add(new UserMessage("aaa", "bbb", "ccc", "dddd"));
        dataset.add(new UserMessage("aaa", "bbb", "ccc", "dddd"));
        dataset.add(new UserMessage("aaa", "bbb", "ccc", "dddd"));

        return dataset;
    }

    private String getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(String userDetail) {
        this.userDetail = userDetail;
    }

    private String getUserTime() {
        return userTime;
    }

    public void setUserTime(String userTime) {
        this.userTime = userTime;
    }

    private String getCpuDetail() {
        return cpuDetail;
    }

    public void setCpuDetail(String cpuDetail) {
        this.cpuDetail = cpuDetail;
    }

    private String getCpuTime() {
        return cpuTime;
    }

    public void setCpuTime(String cpuTime) {
        this.cpuTime = cpuTime;
    }
}

