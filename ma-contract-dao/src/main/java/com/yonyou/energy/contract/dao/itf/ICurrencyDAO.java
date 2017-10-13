package com.yonyou.energy.contract.dao.itf;

import com.yonyou.energy.common.dao.GenericDAO;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.contract.domain.ContractTemplate;
import com.yonyou.energy.contract.domain.Currency;

import java.util.List;

/**
 * Created by tanghe on 2017/10/12.
 */
public interface ICurrencyDAO extends GenericDAO<Currency,Long> {

    int insert(Currency record);

    int deleteByPrimaryKey(Long id);

    Currency selectByPrimaryKey(Long id);

    List<Currency> queryEntity(BaseCriteria criteria);

    int insertBatch(List<Currency> records);

    int updateBatch(List<Currency> records);

    int deleteBatch(BaseCriteria criteria);
}
