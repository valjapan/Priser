package com.valjapan.priser.Data;

public class Message {


    class SelfMessege extends Message {
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

    class CharaMessege extends Message {
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


}
