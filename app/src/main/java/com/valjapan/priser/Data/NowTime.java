package com.valjapan.priser.Data;

import io.realm.RealmObject;

public class NowTime extends RealmObject  {

        public String nowToday;


        public NowTime() {

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

