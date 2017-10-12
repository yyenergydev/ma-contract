package com.yonyou.energy.contract.dao.impl;/**
 * 合同示范文本持久化实现类
 *
 * @author mahonggeng
 * @create 2017-09-22 16:01
 **/

import com.yonyou.energy.common.dao.GenericDAOImpl;
import com.yonyou.energy.common.dao.annotation.TableDesc;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.contract.dao.itf.IContractSampleTextDAO;
import com.yonyou.energy.contract.domain.ContractSampleText;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 合同示范文本持久化实现类
 * @author mahonggeng
 * @create 2017-09-22 16:01
 **/
@Repository
@TableDesc(nameSpace = "com.yonyou.energy.contract.dao.itf.IContractSampleTextDAO",tableName = "sampleText")
public class ContractSampleTextDAOImpl extends GenericDAOImpl<ContractSampleText,Long> implements IContractSampleTextDAO {
    @Override
    public List<ContractSampleText> queryByCondition(BaseCriteria criteria) {
        return getSqlSession().selectList(this.addNameSpace("queryByCondition"),criteria);
    }

    @Override
    public ContractSampleText selectByPrimaryKey(BaseCriteria criteria) {

        return getSqlSession().selectOne(this.addNameSpace("selectByPrimaryKey"),criteria);
    }

    @Override
    public List<ContractSampleText> insertBatch(List<ContractSampleText> list) {
        int count = getSqlSession().insert(this.addNameSpace("insertBatch"),list);
        return list;
    }

    @Override
    public List<ContractSampleText> updateBatch(List<ContractSampleText> list) {
        getSqlSession().update(this.addNameSpace("updateBatch"),list);
        return list;
    }

    @Override
    public int deleteBatch(BaseCriteria criteria) {
        return getSqlSession().delete(this.addNameSpace("deleteBatch"),criteria);
    }

    @Override
    public List<ContractSampleText> checkCode(List<ContractSampleText> list) {
        return getSqlSession().selectList(this.addNameSpace("checkCode"), list);
    }
}