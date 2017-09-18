package com.yonyou.energy.contract.dao.itf;

import com.yonyou.energy.common.dao.GenericDAO;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.contract.domain.ContractType;

import java.util.List;

public interface IContractTypeDAO extends GenericDAO<ContractType,Long> {
    int deleteByPrimaryKey(Long id);

    int insert(ContractType record);

    ContractType selectByPrimaryKey(Long id);

    List<ContractType> queryEntity(BaseCriteria criteria);

    int updateByPrimaryKey(ContractType record);

    int deleteBatch(BaseCriteria criteria);
}