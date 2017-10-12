package com.yonyou.energy.contract.dao.impl;

import com.yonyou.energy.common.dao.GenericDAOImpl;
import com.yonyou.energy.common.dao.annotation.TableDesc;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.contract.dao.itf.IBaseContractDAO;
import com.yonyou.energy.contract.domain.BaseContract;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 标准合同持久层实现类
 * @author mahonggeng
 * @create 2017-09-27 14:40
 **/

@Repository
@TableDesc(nameSpace = "com.yonyou.energy.contract.dao.itf.IBaseContractDAO",tableName = "BaseContract")
public class BaseContractDAOImpl extends GenericDAOImpl<BaseContract,Long> implements IBaseContractDAO {

    @Override
    public BaseContract selectByPrimaryKey(BaseCriteria criteria) {
        return getSqlSession().selectOne(super.addNameSpace("selectByPrimaryKey"),criteria);
    }

    @Override
    public List<BaseContract> queryByCondition(BaseCriteria criteria) {
        return super.queryForList(criteria);
    }

    @Override
    public BaseContract insertEntity(BaseContract entity) {
        super.insert(entity);
        return entity;
    }

    @Override
    public BaseContract updateEntity(BaseContract entity) {
        super.update(entity);
        return entity;
    }

    @Override
    public BaseContract updateStatusById(BaseContract entity) {
        getSqlSession().update(super.addNameSpace("updateStatusById"),entity);
        return entity;
    }

    @Override
    public BaseContract deleteEntity(BaseCriteria criteria) {
        int result = super.delete("deleteByPrimaryKey",criteria.getId());
        return null;
    }
}
