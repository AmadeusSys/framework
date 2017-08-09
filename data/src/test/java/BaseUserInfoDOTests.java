
import data.mapper.RuleMapper;
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
    RuleMapper ruleMapper;

    @Test
    public void test(){

        List rule = ruleMapper.listRuleByUserId("32402d2f73a511e7b47600163e00591d");

        System.out.println(rule);

    }

}
