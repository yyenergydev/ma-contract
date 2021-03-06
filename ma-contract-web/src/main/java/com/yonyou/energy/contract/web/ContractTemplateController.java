package com.yonyou.energy.contract.web;

import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.common.domain.response.ServiceResponse;
import com.yonyou.energy.common.util.JsonUtil;
import com.yonyou.energy.common.web.BaseController;
import com.yonyou.energy.contract.api.IContractTplService;
import com.yonyou.energy.contract.domain.ContractTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by tanghe on 2017/9/27.
 */

@Controller
@RestController
@RequestMapping(value = "/contracttemplate")
public class ContractTemplateController extends BaseController {

    @Autowired
    private IContractTplService contractTplServiceImpl;

    @RequestMapping("/list")
    public String list(BaseCriteria criteria){
        String result = null;
        ServiceResponse<String> response = contractTplServiceImpl.list(criteria);
        result = this.warpResponseArray(response);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody String jsonData, BaseCriteria criteria){
        String result = null;
        try {
            List<ContractTemplate> contractTemplates = (List<ContractTemplate>) JsonUtil.jsonToObject(jsonData, ContractTemplate.class);
            ServiceResponse<String> response = contractTplServiceImpl.save(contractTemplates, criteria);
            result = this.warpResponseArray(response);
        } catch (Exception e) {
            logger.error("保存失败：" + e.getMessage());
            result = this.warpException(e, e.getMessage());//"保存失败"
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody BaseCriteria criteria){
        Logger.getLogger(this.getClass().getName()).info("ContractTemplate delete method :"+criteria.toString());
        ServiceResponse<String> response = contractTplServiceImpl.deleteBatch(criteria);
        String result = this.warpResponseEntity(response);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/open", method = RequestMethod.POST)
    public String open(@RequestBody BaseCriteria criteria){
        ServiceResponse<String> response = contractTplServiceImpl.open(criteria);
        String result = this.warpResponseEntity(response);
        return result;
    }
}
