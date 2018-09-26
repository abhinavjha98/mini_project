package com.example.abhi.mini_app;

public class academics_data {
    String stdid;
    String ms1;
    String ms2;
    String ms3;
    String ms4;
    String ms5;

    public academics_data(){

    }

    public academics_data(String stdid, String ms1, String ms2, String ms3, String ms4, String ms5) {
        this.stdid = stdid;
        this.ms1 = ms1;
        this.ms2 = ms2;
        this.ms3 = ms3;
        this.ms4 = ms4;
        this.ms5 = ms5;
    }

    public String getStdid() {
        return stdid;
    }

    public void setStdid(String stdid) {
        this.stdid = stdid;
    }

    public String getMs1() {
        return ms1;
    }

    public void setMs1(String ms1) {
        this.ms1 = ms1;
    }

    public String getMs2() {
        return ms2;
    }

    public void setMs2(String ms2) {
        this.ms2 = ms2;
    }

    public String getMs3() {
        return ms3;
    }

    public void setMs3(String ms3) {
        this.ms3 = ms3;
    }

    public String getMs4() {
        return ms4;
    }

    public void setMs4(String ms4) {
        this.ms4 = ms4;
    }

    public String getMs5() {
        return ms5;
    }

    public void setMs5(String ms5) {
        this.ms5 = ms5;
    }
}
