package com.yonyou.energy.common.domain;

import java.io.Serializable;
import java.util.Collection;

public class PageBean<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int PAGE_SIZE_MAX = 100;
    private int pageNo = 0;
    private int pageSize = 20;
    private int maxPageSize = 100;
    private long totalCount;
    private Collection<T> resultList;
    private Object[] data;

    public Object[] getData() {
        return this.data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public PageBean() {
    }

    public PageBean(int pageNo, int pageSize) {
        this.setPageNo(pageNo);
        this.setPageSize(pageSize);
    }

    public PageBean(long totalCount, Collection<T> resultList) {
        this.totalCount = totalCount;
        this.resultList = resultList;
    }

    public PageBean(long totalCount, Object[] data) {
        this.totalCount = totalCount;
        this.data = data;
    }

    public long getTotalPage() {
        long totalPage = 0L;
        if (this.totalCount > 0L) {
            totalPage = this.totalCount % (long)this.pageSize == 0L ? this.totalCount / (long)this.pageSize : this.totalCount / (long)this.pageSize + 1L;
        }

        return totalPage;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            pageSize = 20;
        } else if (pageSize > this.maxPageSize) {
            pageSize = this.maxPageSize;
        }

        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(int pageNo) {
        if (pageNo < 1) {
            pageNo = 0;
        }

        this.pageNo = pageNo;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount) {
        if (totalCount < 0L) {
            totalCount = 0L;
        }

        this.totalCount = totalCount;
    }

    public Collection getResultList() {
        return this.resultList == null ? null : this.resultList;
    }

    public void setResultList(Collection<T> resultList) {
        this.resultList = resultList;
    }

    /** @deprecated */
    @Deprecated
    public void setPage(int page) {
        this.setPageNo(page);
    }

    /** @deprecated */
    @Deprecated
    public long getPage() {
        return (long)this.pageNo;
    }

    public int getMaxPageSize() {
        return this.maxPageSize;
    }

    public void setMaxPageSize(int maxPageSize) {
        this.maxPageSize = maxPageSize < 0 ? 100 : maxPageSize;
    }
}
