package com.cb.dt.vo;

import com.cb.dt.domain.Repair;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author lx
 * @create 2021-12-06 12:40
 */
public class RepairVo extends Repair {
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

    /**
     * 时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private int reids[];

    public int[] getReids() {
        return reids;
    }

    public void setReids(int[] reids) {
        this.reids = reids;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
