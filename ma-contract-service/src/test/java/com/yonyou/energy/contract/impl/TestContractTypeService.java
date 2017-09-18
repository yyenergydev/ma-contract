package com.yonyou.energy.contract.impl;

import com.yonyou.energy.common.domain.criteria.BaseCriteria;
import com.yonyou.energy.common.domain.response.ServiceResponse;
import com.yonyou.energy.common.util.JsonUtil;
import com.yonyou.energy.contract.api.IContractTypeService;
import com.yonyou.energy.contract.dao.itf.IContractTypeDAO;
import com.yonyou.energy.contract.domain.ContractType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.logging.Logger;

//@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
//@ContextConfiguration(locations={"/spring-config.xml"}) //加载配置文件
public class TestContractTypeService {

    @Autowired
    private IContractTypeService ser;



    @Test
    public void  testGetHallInfoByTradeId(){
        ContractType contract = new ContractType();
        contract.setId(2l);
        contract.setCode("232");
        contract.setCreator(2323l);
        contract.setDr(0);
        contract.setName("Jack222");

        BaseCriteria criteria = new BaseCriteria();
        ser.save(contract, criteria);

    }

    @Test
    public void testSelectContractType(){
        ServiceResponse<String> response = ser.list(new BaseCriteria());
        System.out.println(response.getResult());
    }


    @Test
    public void testJson(){
        BaseCriteria criteria = new BaseCriteria();
        criteria.setName("Jack");
        Logger.getLogger(TestContractTypeService.class.getName()).info(JsonUtil.objToString(criteria));
    }

}
