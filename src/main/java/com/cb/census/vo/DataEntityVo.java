package com.cb.census.vo;

import com.cb.census.domain.DataEntity;

/**
 * @author lx
 * @create 2021-12-08 21:11
 */
public class DataEntityVo extends DataEntity {
    private String year;
    private int restate;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getRestate() {
        return restate;
    }

    public void setRestate(int restate) {
        this.restate = restate;
    }
}
