package com.yonyou.energy.contract.dao.itf;

import com.yonyou.energy.common.dao.GenericDAO;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.contract.domain.ContractTemplate;

import java.util.List;

/**
 * Created by tanghe on 2017/9/27.
 */
public interface IContractTemplateDAO extends GenericDAO<ContractTemplate,Long> {

    int deleteByPrimaryKey(Long id);

    int insert(ContractTemplate record);

    int insertBatch(List<ContractTemplate> records);

    int updateBatch(List<ContractTemplate> records);

    ContractTemplate selectByPrimaryKey(Long id);

    List<ContractTemplate> queryEntity(BaseCriteria criteria);

    int updateByPrimaryKey(ContractTemplate record);

    int deleteBatch(BaseCriteria criteria);

    int open(BaseCriteria criteria);
}
