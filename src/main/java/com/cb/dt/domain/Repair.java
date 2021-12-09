package com.cb.dt.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Repair {
    private Integer reid;

    private String dtname;

    private String dtfloor;

    private String dtno;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date retime;

    private String rephone;

    private String redescribe;

    private String reimg;

    private String reduty;

    private Integer restate;

    private Integer uid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    public String getDtname() {
        return dtname;
    }

    public void setDtname(String dtname) {
        this.dtname = dtname == null ? null : dtname.trim();
    }

    public String getDtfloor() {
        return dtfloor;
    }

    public void setDtfloor(String dtfloor) {
        this.dtfloor = dtfloor == null ? null : dtfloor.trim();
    }

    public String getDtno() {
        return dtno;
    }

    public void setDtno(String dtno) {
        this.dtno = dtno == null ? null : dtno.trim();
    }

    public Date getRetime() {
        return retime;
    }

    public void setRetime(Date retime) {
        this.retime = retime;
    }

    public String getRephone() {
        return rephone;
    }

    public void setRephone(String rephone) {
        this.rephone = rephone == null ? null : rephone.trim();
    }

    public String getRedescribe() {
        return redescribe;
    }

    public void setRedescribe(String redescribe) {
        this.redescribe = redescribe == null ? null : redescribe.trim();
    }

    public String getReimg() {
        return reimg;
    }

    public void setReimg(String reimg) {
        this.reimg = reimg == null ? null : reimg.trim();
    }

    public String getReduty() {
        return reduty;
    }

    public void setReduty(String reduty) {
        this.reduty = reduty == null ? null : reduty.trim();
    }

    public Integer getRestate() {
        return restate;
    }

    public void setRestate(Integer restate) {
        this.restate = restate;
    }


}