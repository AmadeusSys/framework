package com.xiangmaikeji.framework;

import com.xiangmaikeji.framework.model.BaseUserInfoDO;
import com.xiangmaikeji.framework.service.BaseUserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseUserInfoDOTests {

    @Autowired
    BaseUserInfoService baseUserInfoService;

    @Test
    public void test(){

        BaseUserInfoDO baseUserInfoDO = new BaseUserInfoDO();

        baseUserInfoDO.setPage(2);

        List list = baseUserInfoService.getAll(baseUserInfoDO);

        System.out.println(list);

    }

}
