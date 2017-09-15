package com.yonyou.energy.contract.dao.itf;

import com.yonyou.energy.contract.domain.ContractTypeUsescope;

public interface IContractTypeUsescopeDAO {
    int deleteByPrimaryKey(Long id);

    int insert(ContractTypeUsescope record);

    int insertSelective(ContractTypeUsescope record);

    ContractTypeUsescope selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContractTypeUsescope record);

    int updateByPrimaryKey(ContractTypeUsescope record);
}