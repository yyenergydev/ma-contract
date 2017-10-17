package com.yonyou.energy.contract.dao.impl;

import com.yonyou.energy.common.dao.GenericDAOImpl;
import com.yonyou.energy.common.dao.annotation.TableDesc;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.contract.dao.itf.IContractPuDAO;
import com.yonyou.energy.contract.domain.ContractPu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tanghe on 2017/10/17.
 */
@Repository
@TableDesc(nameSpace = "com.yonyou.energy.contract.mapper.ContractPuMapper",tableName = "ContractPu")
public class ContractPuDAOImpl extends GenericDAOImpl<ContractPu,Long> implements IContractPuDAO {

    @Override
    public ContractPu selectByPrimaryKey(BaseCriteria criteria) {
        return getSqlSession().selectOne(super.addNameSpace("selectByPrimaryKey"),criteria);
    }

    @Override
    public List<ContractPu> queryByCondition(BaseCriteria criteria) {
        return super.queryForList(criteria);
    }

    @Override
    public ContractPu insertEntity(ContractPu entity) {
        super.insert(entity);
        return entity;
    }

    @Override
    public ContractPu updateEntity(ContractPu entity) {
        super.update(entity);
        return entity;
    }

    @Override
    public ContractPu updateStatusById(ContractPu entity) {
        getSqlSession().update(super.addNameSpace("updateStatusById"),entity);
        return entity;
    }

    @Override
    public ContractPu deleteEntity(BaseCriteria criteria) {
        int result = super.delete("deleteByPrimaryKey",criteria.getId());
        return null;
    }
}
