package com.yonyou.energy.common.dao;

import java.util.List;
import java.util.logging.Logger;

import com.yonyou.energy.common.dao.annotation.TableDesc;
import com.yonyou.energy.common.domain.PageBean;
import com.yonyou.energy.common.domain.criteria.Criteria;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.util.Assert;


/**
 * mybatis与spring整合持久化 公共实现类
 * change by mahonggeng
 * change time 2017-09-12 16:01
 **/
public class GenericDAOImpl<E, PK> extends SqlSessionDaoSupport
        implements GenericDAO<E, PK>
{
    public static final String SQL_SELECT = "select";
    public static final String SQL_SELECT_BY_PRIMARY_KEY = "select%sByPrimaryKey";
    public static final String SQL_UPDATE = "update";
    public static final String SQL_REMOVE = "remove";
    public static final String SQL_DELETE = "delete";
    public static final String SQL_INSERT = "insert";
    public static final String SQL_COUNT = "get%sCount";
    public static final String SQL_PAGE_QUERY = "get%sPageQuery";
    public static final String SQL_PAGE_QUERY_COUNT = "get%sPageQueryCount";
    private final String nameSpace;
    private final String tableName;
    private final String sqlSelect;
    private final String sqlSelectByPrimaryKey;
    private final String sqlCount;
    private final String sqlInsert;
    private final String sqlUpdate;
    private final String sqlRemove;
    private final String sqlDelete;
    private final String sqlPageQuery;
    private final String sqlPageQueryCount;

    public GenericDAOImpl()
    {
        TableDesc myTable = (TableDesc)getClass().getAnnotation(TableDesc.class);
        Assert.notNull(myTable);
        this.tableName = (myTable.tableName() == null ? "" : myTable.tableName());

        String nameSpaceTmp = myTable.nameSpace();
        this.nameSpace = (nameSpaceTmp + ".");
        this.sqlSelect = ("select" + this.tableName);
        this.sqlSelectByPrimaryKey = String.format("select%sByPrimaryKey", new Object[] { this.tableName });
        this.sqlInsert = ("insert" + this.tableName);
        this.sqlUpdate = ("update" + this.tableName);
        this.sqlRemove = ("remove" + this.tableName);
        this.sqlDelete = ("delete" + this.tableName);
        this.sqlCount = String.format("get%sCount", new Object[] { this.tableName });

        this.sqlPageQuery = String.format("get%sPageQuery", new Object[] { this.tableName });
        this.sqlPageQueryCount = String.format("get%sPageQueryCount", new Object[] { this.tableName });
    }

    public int insert(E entity) {
        log(this.sqlInsert);
        return insert(this.sqlInsert, entity);
    }

    public int update(E entity) {
        return update(this.sqlUpdate, entity);
    }

    public int remove(E entity)
    {
        return update(this.sqlRemove, entity);
    }

    public int delete(PK id) {
        return delete(this.sqlDelete, id);
    }

    public E get(PK id)
    {
        E entity = get(this.sqlSelectByPrimaryKey, id);
        return entity == null ? null : entity;
    }

    public long getCount(Criteria criteria) {
        return getCountBy(this.sqlCount, criteria);
    }

    public List<E> queryForList(Criteria criteria)
    {
        return queryForList(this.sqlSelect, criteria);
    }


    public Object[] queryForArray(Criteria criteria)
    {
        List<E> datalist= queryForList(this.sqlSelect, criteria);
        if(datalist==null||datalist.size()<=0)
            return  null;
        return datalist.toArray();
    }

    public List<E> queryForPageList(Criteria criteria, PageBean<?> pageCriteria)
    {
        Assert.notNull(criteria, "查询条件不能为空.");
        Assert.notNull(pageCriteria, "分页条件不能为空.");
        criteria.addExtField("start", Long.valueOf((pageCriteria.getPageNo()) * pageCriteria.getPageSize()));
        criteria.addExtField("limit", Integer.valueOf(pageCriteria.getPageSize()));
        List resultList = queryForList(criteria);
        return resultList;
    }

    public PageBean<E> pageQuery(Criteria criteria, PageBean<E> pageBean) {
        Assert.notNull(criteria, "查询条件不能为空.");
        Assert.notNull(pageBean, "分页条件不能为空.");
        long count = getCount(criteria);
        pageBean.setTotalCount(count);
        if (count == 0L) {
            return pageBean;
        }
        criteria.addExtField("start", Long.valueOf((pageBean.getPageNo()) * pageBean.getPageSize()));
        criteria.addExtField("limit", Integer.valueOf(pageBean.getPageSize()));
        //  List resultList = queryForArray(criteria);
        // pageBean.setResultList(resultList);
        //返回数组
        pageBean.setData( queryForArray(criteria));
        return pageBean;
    }

    /**
     * 为了返回list
     * @param criteria
     * @param pageBean
     * @return
     */
    public PageBean<E> pageQueryForList(Criteria criteria, PageBean<E> pageBean) {
        Assert.notNull(criteria, "查询条件不能为空.");
        Assert.notNull(pageBean, "分页条件不能为空.");
        long count = getCount(criteria);
        pageBean.setTotalCount(count);
        if (count == 0L) {
            return pageBean;
        }
        criteria.addExtField("start", Long.valueOf((pageBean.getPageNo()) * pageBean.getPageSize()));
        criteria.addExtField("limit", Integer.valueOf(pageBean.getPageSize()));
        List resultList = queryForList(criteria);
        pageBean.setResultList(resultList);
        return pageBean;
    }

    public boolean exists(PK id) {
        return exists(this.sqlSelect, id);
    }

    protected int insert(String statement, Object entity)
    {
        return getSqlSession().insert(addNameSpace(statement), entity);
    }

    protected int update(String statement, Object entity)
    {
        return getSqlSession().update(addNameSpace(statement), entity);
    }

    protected int delete(String statement, Object id)
    {
        return getSqlSession().delete(addNameSpace(statement), id);
    }

    protected E get(String statement, Object criteria)
    {
        Object object = getSqlSession().selectOne(addNameSpace(statement), criteria);
        return object == null ? null : ((E) object);
    }

    protected <T> List<T> queryForList(String statement, Object criteria)
    {
        List result = getSqlSession().selectList(addNameSpace(statement), criteria);
        return result;
    }

    protected boolean exists(String statement, Object id)
    {
        return (get(statement, id) == null ? Boolean.FALSE : Boolean.TRUE).booleanValue();
    }

    protected String addNameSpace(String statement)
    {
        statement = this.nameSpace + statement;
        log(statement);
        return statement;
    }

    protected long getCountBy(String statement, Object criteria)
    {
        Object result = getSqlSession().selectOne(addNameSpace(statement), criteria);
        long count;
        try
        {
            count = (result instanceof Integer) ? ((Integer)result).intValue() : null == result ? 0L : ((Long)result).longValue();
        } catch (ClassCastException e) {
            //this.logger.error("sql语句：" + statement + "查询结果非数字类型，无法用于查询数量");
            throw e;
        }
        return count;
    }

    protected <T> PageBean<T> pageQueryBy(String countStatement, String listStatement, Criteria criteria, PageBean<T> pageBean)
    {
        Assert.notNull(criteria, "查询条件不能为空.");
        Assert.notNull(pageBean, "分页条件不能为空.");
        long count = getCountBy(countStatement, criteria);
        pageBean.setTotalCount(count);
        if (count == 0L) {
            return pageBean;
        }
        criteria.addExtField("start", Long.valueOf((pageBean.getPageNo()) * pageBean.getPageSize()));
        criteria.addExtField("limit", Integer.valueOf(pageBean.getPageSize()));

        List resultList = queryForList(listStatement, criteria);
        pageBean.setResultList(resultList);
        if(resultList != null && resultList.size() >0){
            pageBean.setData(resultList.toArray(new Object[0]));
        }

        return pageBean;
    }

    public PageBean<E> pageQuery(Criteria paramQ, Long paramLong,
                                 Integer paramInteger) {

        return null;
    }

    public void log(String msg){
        Logger.getLogger(this.getClass().getName()).info(msg);
    }


}