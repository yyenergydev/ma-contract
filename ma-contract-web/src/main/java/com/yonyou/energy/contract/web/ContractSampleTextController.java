package com.yonyou.energy.contract.web;

import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.common.domain.response.ServiceResponse;
import com.yonyou.energy.common.util.JsonUtil;
import com.yonyou.energy.common.util.JsonUtils;
import com.yonyou.energy.common.web.BaseController;
import com.yonyou.energy.contract.api.IContractSampleTextService;
import com.yonyou.energy.contract.domain.ContractSampleText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 合同示范文本REST服务
 * @author mahonggeng
 * @create 2017-09-22 16:07
 **/
@Controller
@RestController
@RequestMapping(value = "/contractsampletext")
public class ContractSampleTextController extends BaseController {

    @Resource
    private IContractSampleTextService contractSampleTextService;

    @RequestMapping(value = "/list")
    public String list(BaseCriteria criteria){

        System.out.println("Jack----------------------list--------------------------");
        Logger.getLogger(this.getClass().getName()).info("ContractSampleText list method :"+criteria.toString());

        String result = null;
        ServiceResponse<String> response = contractSampleTextService.list(criteria);
        result = this.warpResponseArray(response);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/queryByPk")
    public String queryByPk(BaseCriteria criteria){

        System.out.println("Jack----------------------queryByPk--------------------------");
        Logger.getLogger(this.getClass().getName()).info("ContractSampleText queryByPk method :"+criteria.toString());

        String result = null;
        ServiceResponse<String> response = contractSampleTextService.selectByPk(criteria);
        result = this.warpResponseEntity(response, ContractSampleText.class);
        Logger.getLogger(this.getClass().getName()).info("ContractSampleText queryByPk method result :"+result);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody String  jsonData, BaseCriteria criteria ){
        System.out.println("Jack----------------------save--------------------------");
        String result = null;
        try {
            //ContractSampleText contractType = JsonUtil.jsonToObject(jsonData, ContractSampleText.class);
            //List<ContractSampleText> contractSampleTexts = JsonUtils.fromJsonArray(jsonData, ContractSampleText.class);
            List<ContractSampleText> contractSampleTexts = new ArrayList<>();
            boolean arr = false;
            try {
                ContractSampleText contractSampleText = JsonUtils.fromJson(jsonData, ContractSampleText.class);
                contractSampleTexts.add(contractSampleText);
                arr = false;
            }catch (Exception ee){
                contractSampleTexts = JsonUtils.fromJsonArray(jsonData, ContractSampleText.class);
                arr = true;
            }

            ServiceResponse<String> response = contractSampleTextService.save(contractSampleTexts, criteria);
            if(arr)
                result = this.warpResponseArray(response);
            else
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
        System.out.println("Jack----------------------delete--------------------------");
        Logger.getLogger(this.getClass().getName()).info("ContractSampleText delete method :"+criteria.toString());

        ServiceResponse<String> response = contractSampleTextService.deleteBatch(criteria);
        String result = this.warpResponseEntity(response);
        return result;
    }
}
