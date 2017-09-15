package com.yonyou.energy.common.domain.criteria;


public class PageCriteria extends Criteria{


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer totalPage;

    private Integer pageSize=10;

    private Integer pageIndex=0;

    private Integer totalCount;

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }



}
