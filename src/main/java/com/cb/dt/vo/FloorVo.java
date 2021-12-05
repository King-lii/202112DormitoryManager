package com.cb.dt.vo;

import com.cb.dt.domain.Floor;

/**
 * @author lx
 * @create 2021-12-03 20:54
 */
public class FloorVo extends Floor {
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

    private int ids[];

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

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }
}
