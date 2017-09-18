package com.yonyou.energy.contract.dao.itf;

import com.yonyou.energy.common.dao.GenericDAO;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.contract.domain.ContractTypeUsescope;

import java.util.List;

public interface IContractTypeUsescopeDAO extends GenericDAO<ContractTypeUsescope,Long> {
    int deleteByPrimaryKey(Long id);

    int insert(ContractTypeUsescope record);

    int insertBatch(List<ContractTypeUsescope> list);

    int deleteBatch(BaseCriteria criteria);

    ContractTypeUsescope selectByPrimaryKey(Long id);

    int updateByPrimaryKey(ContractTypeUsescope record);

    List<ContractTypeUsescope> selectByContractTypeId(Long contractTypeId);
}