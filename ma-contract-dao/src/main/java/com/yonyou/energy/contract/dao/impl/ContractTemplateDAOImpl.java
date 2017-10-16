package com.yonyou.energy.contract.dao.impl;

import com.yonyou.energy.common.dao.GenericDAOImpl;
import com.yonyou.energy.common.dao.annotation.TableDesc;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.contract.dao.itf.IContractTemplateDAO;
import com.yonyou.energy.contract.domain.ContractTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tanghe on 2017/9/27.
 */

@Repository
@TableDesc(nameSpace = "com.yonyou.energy.contract.mapper.ContractTemplateMapper", tableName = "ContractTemplate")
public class ContractTemplateDAOImpl extends GenericDAOImpl<ContractTemplate, Long> implements IContractTemplateDAO {
    String nameSpance = "com.yonyou.energy.contract.mapper.ContractTemplateMapper";

    @Override
    public int deleteByPrimaryKey(Long id) {
        return super.delete(id);
    }

    @Override
    public ContractTemplate selectByPrimaryKey(Long id) {
        return getSqlSession().selectOne(nameSpance+".selectByPrimaryKey",id);
    }

    @Override
    public List<ContractTemplate> queryEntity(BaseCriteria criteria) {
        List list = super.queryForList("queryEntity",criteria);
        return list;
    }

    @Override
    public int updateByPrimaryKey(ContractTemplate record) {
        return super.update("updateByPrimaryKey",record);
    }

    @Override
    public int deleteBatch(BaseCriteria criteria) {
        if (criteria.getIds() != null && criteria.getIds().length > 0) {
            return super.update("deleteBatch", criteria.getIds());
        } else {
            return 0;
        }
    }

    @Override
    public int insertBatch(List<ContractTemplate> contractTemplates) {
        return super.insert("insertBatch", contractTemplates);
    }

    @Override
    public int updateBatch(List<ContractTemplate> contractTemplates) {
        return super.update("updateBatch", contractTemplates);
    }

    @Override
    public int open(BaseCriteria criteria) {
        if (criteria.getIds() != null && criteria.getIds().length > 0) {
            return getSqlSession().update(this.nameSpance+".setOpenBatch", criteria.getIds());
        } else {
            return 0;
        }
    }
}
