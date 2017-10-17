package com.yonyou.energy.contract.api;

import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.common.domain.response.ServiceResponse;
import com.yonyou.energy.contract.domain.ContractPu;

/**
 * Created by tanghe on 2017/10/17.
 */
public interface IContractPuService {

    /**
     * 列表查询
     * @param criteria
     * @return
     */
    public ServiceResponse<String> list(BaseCriteria criteria);

    /**
     * 通过pk查询
     * @param criteria
     * @return
     */
    public ServiceResponse<String> selectByPk(BaseCriteria criteria);

    /**
     * 暂存（新增保存，修改保存）
     * @param data
     * @return
     */
    public ServiceResponse<String> tempsave(ContractPu data, BaseCriteria criteria);

    /**
     * 提交
     * @param data
     * @return
     */
    public ServiceResponse<String> save(ContractPu data, BaseCriteria criteria);

    /**
     * 删除
     * @param criteria
     * @return
     */
    public ServiceResponse<String>  delete(BaseCriteria criteria);
}
