package com.cb.dt.domain;

public class Floor {
    private Integer dtid;

    private Integer dtsex;

    private Integer dtnumber;

    private String dtsize;

    private String dtimg;

    private String dtname;

    private String dtfloor;

    private String dtno;

    public Integer getDtid() {
        return dtid;
    }

    public void setDtid(Integer dtid) {
        this.dtid = dtid;
    }

    public Integer getDtsex() {
        return dtsex;
    }

    public void setDtsex(Integer dtsex) {
        this.dtsex = dtsex;
    }

    public Integer getDtnumber() {
        return dtnumber;
    }

    public void setDtnumber(Integer dtnumber) {
        this.dtnumber = dtnumber;
    }

    public String getDtsize() {
        return dtsize;
    }

    public void setDtsize(String dtsize) {
        this.dtsize = dtsize == null ? null : dtsize.trim();
    }

    public String getDtimg() {
        return dtimg;
    }

    public void setDtimg(String dtimg) {
        this.dtimg = dtimg == null ? null : dtimg.trim();
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
}