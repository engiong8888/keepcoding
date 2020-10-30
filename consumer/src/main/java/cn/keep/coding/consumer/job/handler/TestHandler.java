package cn.keep.coding.consumer.job.handler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestHandler
 * @Description TODO
 * @mail
 * @Author cheng
 * @Date 2020/10/26 17:13
 * @Version 1.0
 */
@JobHandler(value="TestHandler")
@Component
public class TestHandler extends IJobHandler {
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        System.out.println("执行了TestHandler一次");
        return SUCCESS;
    }
}
