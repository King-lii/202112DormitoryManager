package com.cb.dt.vo;

import com.cb.dt.domain.Visitor;

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
