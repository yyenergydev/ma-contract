package com.yonyou.energy.contract.dao.impl;

import com.yonyou.energy.common.dao.GenericDAOImpl;
import com.yonyou.energy.common.dao.annotation.TableDesc;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.contract.dao.itf.IContractTypeDAO;
import com.yonyou.energy.contract.domain.ContractType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@TableDesc(nameSpace = "com.yonyou.energy.contract.dao.itf.IContractTypeDAO", tableName = "ContractType")
public class ContractTypeDAOImpl extends GenericDAOImpl<ContractType, Long> implements IContractTypeDAO {
    String nameSpance = "com.yonyou.energy.contract.dao.itf.IContractTypeDAO";

    @Override
    public int deleteByPrimaryKey(Long id) {
        return super.delete(id);
    }

    @Override
    public ContractType selectByPrimaryKey(Long id) {
        //Mapper mapper = getSqlSession().getMapper(ContractType.class);

        return getSqlSession().selectOne(nameSpance+".selectByPrimaryKey",id);
        //return super.get(id);
    }

    @Override
    public List<ContractType> queryEntity(BaseCriteria criteria) {
        //List list1 = super.queryForList(criteria);
        List list2 = super.queryForList("queryEntity",criteria);
        //List list3 = getSqlSession().selectList(nameSpance+".queryEntity");
        return list2;
    }

    @Override
    public int updateByPrimaryKey(ContractType record) {
        return super.update("updateByPrimaryKey",record);
    }

    @Override
    public int deleteBatch(BaseCriteria criteria) {
        if(criteria.getIds()!=null && criteria.getIds().length>0){
            criteria.setIdstr(criteria.getIds().toString());
        }
        return getSqlSession().delete(this.nameSpance+".deleteBatch",criteria);
    }
}
