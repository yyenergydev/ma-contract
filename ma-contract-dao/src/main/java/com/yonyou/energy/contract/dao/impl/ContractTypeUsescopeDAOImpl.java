package com.yonyou.energy.contract.dao.impl;
import com.yonyou.energy.common.dao.GenericDAOImpl;
import com.yonyou.energy.common.dao.annotation.TableDesc;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.contract.dao.itf.IContractTypeUsescopeDAO;
import com.yonyou.energy.contract.domain.ContractTypeUsescope;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@TableDesc(nameSpace = "com.yonyou.energy.contract.dao.itf.IContractTypeUsescopeDAO",tableName = "usescope")
public class ContractTypeUsescopeDAOImpl extends GenericDAOImpl<ContractTypeUsescope,Long> implements IContractTypeUsescopeDAO {
    private String nameSpance = "com.yonyou.energy.contract.dao.itf.IContractTypeUsescopeDAO";

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public ContractTypeUsescope selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(ContractTypeUsescope record) {
        return 0;
    }

    @Override
    public List<ContractTypeUsescope> selectByContractTypeId(Long contractTypeId) {

        return getSqlSession().selectList(nameSpance+".selectByContractTypeId",contractTypeId);
    }

    @Override
    public int insertBatch(List<ContractTypeUsescope> list) {
        return getSqlSession().insert(nameSpance+".insertBatch",list);
    }

    @Override
    public int deleteBatch(BaseCriteria criteria) {
        if(criteria.getIds()!=null && criteria.getIds().length>0){
            criteria.setIdstr(criteria.getIds().toString());
        }
        return getSqlSession().delete(nameSpance+".deleteBatch",criteria);
    }
}
