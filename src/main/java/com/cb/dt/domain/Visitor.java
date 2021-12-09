package com.cb.dt.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Visitor {
    private Integer id;

    private String vtname;

    private String vtphone;

    private Integer vtsex;

    private String vtidentity;

    private String vtroom;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date vtbetime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date vtendtime;

    private String vtdes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVtname() {
        return vtname;
    }

    public void setVtname(String vtname) {
        this.vtname = vtname == null ? null : vtname.trim();
    }

    public String getVtphone() {
        return vtphone;
    }

    public void setVtphone(String vtphone) {
        this.vtphone = vtphone == null ? null : vtphone.trim();
    }

    public Integer getVtsex() {
        return vtsex;
    }

    public void setVtsex(Integer vtsex) {
        this.vtsex = vtsex;
    }

    public String getVtidentity() {
        return vtidentity;
    }

    public void setVtidentity(String vtidentity) {
        this.vtidentity = vtidentity == null ? null : vtidentity.trim();
    }

    public String getVtroom() {
        return vtroom;
    }

    public void setVtroom(String vtroom) {
        this.vtroom = vtroom == null ? null : vtroom.trim();
    }

    public Date getVtbetime() {
        return vtbetime;
    }

    public void setVtbetime(Date vtbetime) {
        this.vtbetime = vtbetime;
    }

    public Date getVtendtime() {
        return vtendtime;
    }

    public void setVtendtime(Date vtendtime) {
        this.vtendtime = vtendtime;
    }

    public String getVtdes() {
        return vtdes;
    }

    public void setVtdes(String vtdes) {
        this.vtdes = vtdes == null ? null : vtdes.trim();
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", vtname='" + vtname + '\'' +
                ", vtphone='" + vtphone + '\'' +
                ", vtsex=" + vtsex +
                ", vtidentity='" + vtidentity + '\'' +
                ", vtroom='" + vtroom + '\'' +
                ", vtbetime=" + vtbetime +
                ", vtendtime=" + vtendtime +
                ", vtdes='" + vtdes + '\'' +
                '}';
    }
}