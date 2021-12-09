package com.cb.dt.vo;

import com.cb.dt.domain.Visitor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author lx
 * @create 2021-12-01 16:32
 */
public class VisitorVo extends Visitor {
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

    // 接收多个id
    private int[] ids;
    //模糊查询传参
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date searchbetime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date searchendtime;
    //插入数据和更新数据传参
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date vtstartime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date vtouttime;

    public Date getVtstartime() {
        return vtstartime;
    }

    public void setVtstartime(Date vtstartime) {
        this.vtstartime = vtstartime;
    }

    public Date getVtouttime() {
        return vtouttime;
    }

    public void setVtouttime(Date vtouttime) {
        this.vtouttime = vtouttime;
    }

    public Date getSearchbetime() {
        return searchbetime;
    }

    public void setSearchbetime(Date searchbetime) {
        this.searchbetime = searchbetime;
    }

    public Date getSearchendtime() {
        return searchendtime;
    }

    public void setSearchendtime(Date searchendtime) {
        this.searchendtime = searchendtime;
    }

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
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
