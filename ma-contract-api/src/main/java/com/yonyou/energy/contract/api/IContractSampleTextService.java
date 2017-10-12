package com.yonyou.energy.contract.api;

import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.common.domain.response.ServiceResponse;
import com.yonyou.energy.contract.domain.ContractSampleText;

import java.util.List;

/**
 * 合同示范文本服务接口
 * @author mahonggeng
 * @create 2017-09-22 16:18
 **/
public interface IContractSampleTextService {

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
     * 保存（新增保存，修改保存）
     * @param data
     * @return
     */
    public ServiceResponse<String> save(List<ContractSampleText> data, BaseCriteria criteria);

    /**
     * 删除
     * @param criteria
     * @return
     */
    public ServiceResponse<String>  deleteBatch(BaseCriteria criteria);
}
