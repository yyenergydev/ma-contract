package com.yonyou.energy.common.dao;

import com.yonyou.energy.common.domain.PageBean;
import com.yonyou.energy.common.domain.criteria.Criteria;

import java.util.List;

/**
 * mybatis与spring整合持久化 公共接口
 * change by mahonggeng
 * change time 2017-09-12 16:01
 **/
public  interface GenericDAO<E, PK>
{
    public  int insert(E paramE);

    public  int update(E paramE);

    public  int remove(E paramE);

    public  int delete(PK paramPK);

    public  E get(PK paramPK);

    public  long getCount(Criteria paramCriteria);

    public  List<E> queryForList(Criteria paramCriteria);

    public  List<E> queryForPageList(Criteria paramCriteria, PageBean<?> paramPageBean);

    public  PageBean<E> pageQuery(Criteria paramCriteria, PageBean<E> paramPageBean);

    public  PageBean<E> pageQueryForList(Criteria paramCriteria, PageBean<E> paramPageBean);

    public  PageBean<E> pageQuery(Criteria paramQ, Long paramLong, Integer paramInteger);

    public   boolean exists(PK paramPK);
}