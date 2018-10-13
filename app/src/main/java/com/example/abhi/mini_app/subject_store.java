package com.example.abhi.mini_app;

public class subject_store {
    String sid;
    String ss1;
    String ss2;
    String ss3;
    String ss4;
    String ss5;

    public subject_store(){

    }

    public subject_store(String sid, String ss1, String ss2, String ss3, String ss4, String ss5) {
        this.sid = sid;
        this.ss1 = ss1;
        this.ss2 = ss2;
        this.ss3 = ss3;
        this.ss4 = ss4;
        this.ss5 = ss5;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSs1() {
        return ss1;
    }

    public void setSs1(String ss1) {
        this.ss1 = ss1;
    }

    public String getSs2() {
        return ss2;
    }

    public void setSs2(String ss2) {
        this.ss2 = ss2;
    }

    public String getSs3() {
        return ss3;
    }

    public void setSs3(String ss3) {
        this.ss3 = ss3;
    }

    public String getSs4() {
        return ss4;
    }

    public void setSs4(String ss4) {
        this.ss4 = ss4;
    }

    public String getSs5() {
        return ss5;
    }

    public void setSs5(String ss5) {
        this.ss5 = ss5;
    }
}
