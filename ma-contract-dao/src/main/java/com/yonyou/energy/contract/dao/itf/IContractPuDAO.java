package com.yonyou.energy.contract.dao.itf;

import com.yonyou.energy.common.dao.GenericDAO;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.contract.domain.ContractPu;

import java.util.List;

/**
 * Created by tanghe on 2017/10/17.
 */
public interface IContractPuDAO extends GenericDAO<ContractPu,Long> {
    ContractPu selectByPrimaryKey(BaseCriteria criteria);

    List<ContractPu> queryByCondition(BaseCriteria criteria);

    ContractPu insertEntity(ContractPu entity);

    ContractPu updateEntity(ContractPu entity);

    ContractPu updateStatusById(ContractPu entity);

    ContractPu deleteEntity(BaseCriteria criteria);
}
