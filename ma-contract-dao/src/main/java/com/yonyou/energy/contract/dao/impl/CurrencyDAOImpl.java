package com.yonyou.energy.contract.dao.impl;

import com.yonyou.energy.common.dao.GenericDAOImpl;
import com.yonyou.energy.common.dao.annotation.TableDesc;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.contract.dao.itf.ICurrencyDAO;
import com.yonyou.energy.contract.domain.Currency;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tanghe on 2017/10/12.
 */
@Repository
@TableDesc(nameSpace = "com.yonyou.energy.contract.mapper.CurrencyMapper", tableName = "Currency")
public class CurrencyDAOImpl extends GenericDAOImpl<Currency, Long> implements ICurrencyDAO {
    String nameSpance = "com.yonyou.energy.contract.mapper.CurrencyMapper";

    @Override
    public int deleteByPrimaryKey(Long id) {
        return super.delete(id);
    }

    @Override
    public Currency selectByPrimaryKey(Long id) {
        return getSqlSession().selectOne(nameSpance+".selectByPrimaryKey",id);
    }

    @Override
    public List<Currency> queryEntity(BaseCriteria criteria) {
        List list = super.queryForList("queryEntity",criteria);
        return list;
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
    public int insertBatch(List<Currency> records) {
        return super.insert("insertBatch", records);
    }

    @Override
    public int updateBatch(List<Currency> records) {
        return super.update("updateBatch", records);
    }
}
