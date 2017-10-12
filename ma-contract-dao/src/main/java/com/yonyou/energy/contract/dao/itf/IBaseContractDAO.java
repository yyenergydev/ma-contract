package com.yonyou.energy.contract.dao.itf;

import com.yonyou.energy.common.dao.GenericDAO;
import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.contract.domain.BaseContract;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author mahonggeng
 * @create 2017-09-27 14:39
 **/
public interface IBaseContractDAO extends GenericDAO<BaseContract,Long> {

    BaseContract selectByPrimaryKey(BaseCriteria criteria);

    List<BaseContract> queryByCondition(BaseCriteria criteria);

    BaseContract insertEntity(BaseContract list);

    BaseContract updateEntity(BaseContract list);

    BaseContract updateStatusById(BaseContract entity);

    BaseContract deleteEntity(BaseCriteria criteria);
}
