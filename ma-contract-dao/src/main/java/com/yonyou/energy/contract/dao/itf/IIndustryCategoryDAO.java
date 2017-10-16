package com.yonyou.energy.contract.dao.itf;

import com.yonyou.energy.common.dao.GenericDAO;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.contract.domain.Currency;
import com.yonyou.energy.contract.domain.IndustryCategory;

import java.util.List;

/**
 * Created by tanghe on 2017/10/12.
 */
public interface IIndustryCategoryDAO extends GenericDAO<IndustryCategory,Long> {

    int insert(IndustryCategory record);

    int deleteByPrimaryKey(Long id);

    IndustryCategory selectByPrimaryKey(Long id);

    List<IndustryCategory> queryEntity(BaseCriteria criteria);

    int insertBatch(List<IndustryCategory> records);

    int updateBatch(List<IndustryCategory> records);

    int deleteBatch(BaseCriteria criteria);
}
