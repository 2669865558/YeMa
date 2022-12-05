package com.dachun.entity;

/**
 * @className AbsQuery
 * @description TODO
 * @date 2022/12/4 21:41
 */
public abstract class AbsQuery {
    private Integer pageSize;
    private  Integer pageNum;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
