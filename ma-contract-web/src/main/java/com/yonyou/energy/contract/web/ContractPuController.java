package com.yonyou.energy.contract.web;

import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.common.domain.response.ServiceResponse;
import com.yonyou.energy.common.util.JsonUtils;
import com.yonyou.energy.common.web.BaseController;
import com.yonyou.energy.contract.api.IContractPuService;
import com.yonyou.energy.contract.domain.ContractPu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.logging.Logger;

/**
 * Created by tanghe on 2017/10/17.
 */

@Controller
@RestController
@RequestMapping(value = "/contract_pu")
public class ContractPuController extends BaseController {

    @Resource
    private IContractPuService contractPuService;

    @RequestMapping(value = "/list")
    public String list(BaseCriteria criteria){
        Logger.getLogger(this.getClass().getName()).info("ContractPu list method :"+criteria.toString());
        String result = null;
        ServiceResponse<String> response = contractPuService.list(criteria);
        result = this.warpResponseArray(response);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/queryByPk")
    public String queryByPk(BaseCriteria criteria){
        Logger.getLogger(this.getClass().getName()).info("ContractPu queryByPk method :"+criteria.toString());
        String result = null;
        ServiceResponse<String> response = contractPuService.selectByPk(criteria);
        result = this.warpResponseEntity(response, ContractPu.class);
        Logger.getLogger(this.getClass().getName()).info("ContractPu queryByPk method result :"+result);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/tempsave", method = RequestMethod.POST)
    public String tempsave(@RequestBody String jsonData, BaseCriteria criteria){
        String result = null;
        try {
            ContractPu contractPu = JsonUtils.fromJson(jsonData, ContractPu.class);
            ServiceResponse<String> response = contractPuService.tempsave(contractPu, criteria);
            result = this.warpResponseEntity(response);
        } catch (Exception e) {
            logger.error("保存失败：" + e.getMessage());
            result = this.warpException(e, e.getMessage());//"保存失败"
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody String jsonData, BaseCriteria criteria){
        String result = null;
        try {
            ContractPu contractPu = JsonUtils.fromJson(jsonData, ContractPu.class);
            ServiceResponse<String> response = contractPuService.save(contractPu, criteria);
            result = this.warpResponseEntity(response);
        } catch (Exception e) {
            logger.error("保存失败：" + e.getMessage());
            result = this.warpException(e, e.getMessage());//"保存失败"
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody BaseCriteria criteria){
        Logger.getLogger(this.getClass().getName()).info("ContractPu delete method :"+criteria.toString());
        ServiceResponse<String> response = contractPuService.delete(criteria);
        String result = this.warpResponseEntity(response);
        return result;
    }
}
