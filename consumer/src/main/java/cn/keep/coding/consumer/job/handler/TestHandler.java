package cn.keep.coding.consumer.job.handler;

import cn.keep.coding.consumer.service.TestService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestHandler
 * @Description TODO
 * @mail
 * @Author cheng
 * @Date 2020/10/26 17:13
 * @Version 1.0
 */

@Component
public class TestHandler extends IJobHandler {

    @Autowired
    TestService testService;

    @XxlJob("demoJobHandler")
    public ReturnT<String> execute(String param) {

        XxlJobLogger.log("hello world.");
        testService.queryOne();
        return ReturnT.SUCCESS;
    }
}
