package com.yonyou.energy.contract.api;

import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.common.domain.response.ServiceResponse;
import com.yonyou.energy.contract.domain.ContractTemplate;

import java.util.List;

/**
 * Created by tanghe on 2017/9/27.
 */
public interface IContractTplService {

    /**
     * 列表查询
     * @param criteria
     * @return
     */
    public ServiceResponse<String> list(BaseCriteria criteria);

    /**
     * 保存（新增保存，修改保存）
     * @param data
     * @return
     */
    public ServiceResponse<String> save(List<ContractTemplate> data, BaseCriteria criteria);

    /**
     * 删除
     * @param criteria
     * @return
     */
    public ServiceResponse<String>  deleteBatch(BaseCriteria criteria);

    /**
     * 启用
     * @param criteria
     * @return
     */
    public ServiceResponse<String>  open(BaseCriteria criteria);
}
