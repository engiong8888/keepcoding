package cn.keep.coding.push.provider.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName TestServiceTest
 * @Description 测试多数据源
 * @mail
 * @Author cheng
 * @Date 2020/10/23 16:27
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServiceTest {
    @Autowired
    private TestService testService;

    @Test
    public void test(){
        testService.queryOne();
    }
}
