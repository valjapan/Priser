package com.valjapan.priser.Data;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;

public class NowTime extends RealmObject  {

        public String nowToday;


        public NowTime() {

        }

        public static List<NowTime> createDummyData(){
            List<NowTime> dataSet = new ArrayList<>();
            dataSet.add(new NowTime("2018 05-16"));
            dataSet.add(new NowTime("2018 05-17"));
            dataSet.add(new NowTime("2018 05-18"));
            dataSet.add(new NowTime("2018 05-19"));

            return dataSet;
        }

        public NowTime( String nowToday) {

            this.nowToday = nowToday;
        }


        public String getNowToday() {
            return nowToday;
        }

        public void setNowToday(String nowToday) {
            this.nowToday = nowToday;
        }
}

