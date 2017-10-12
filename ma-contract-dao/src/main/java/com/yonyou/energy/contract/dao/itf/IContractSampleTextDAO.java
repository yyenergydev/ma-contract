package com.yonyou.energy.contract.dao.itf;

import com.yonyou.energy.common.dao.GenericDAO;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.contract.domain.ContractSampleText;

import java.util.List;

/**
 * 合同示范文本持久化接口
 * @author mahonggeng
 * @create 2017-09-22 15:33
 **/
public interface IContractSampleTextDAO extends GenericDAO<ContractSampleText,Long> {
    /*int deleteByPrimaryKey(Long id);

    int insert(ContractSampleText record);

    int insertSelective(ContractSampleText record);

    ContractSampleText selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContractSampleText record);

    int updateByPrimaryKey(ContractSampleText record);*/

    ContractSampleText selectByPrimaryKey(BaseCriteria criteria);

    List<ContractSampleText> queryByCondition(BaseCriteria criteria);

    List<ContractSampleText> insertBatch(List<ContractSampleText> list);

    List<ContractSampleText> updateBatch(List<ContractSampleText> list);

    int deleteBatch(BaseCriteria criteria);

    List<ContractSampleText> checkCode(List<ContractSampleText> list);
}