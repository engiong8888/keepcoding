package cn.keep.coding.push.provider.controller;

import cn.keep.coding.base.db.SimpleMybatisDao;
import cn.keep.coding.push.provider.config.SpringContextBean;
import cn.keep.coding.push.provider.service.TestService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Description 测试
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestService testService;

    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * @param request
     * @param response
     * @param rParams
     * @return
     */
    @PostMapping("/query")
    @ResponseBody
    @DependsOn("springUtil")
    public String getPushMailRecord(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject rParams) {
        JSONObject result = new JSONObject();
        try {
            JSONObject qParams = new JSONObject();
            qParams.put("remark", "111");
            logger.info(new StringBuffer("查询，参数：").append(JSONObject.toJSONString(qParams)).toString());
            SimpleMybatisDao simpleMybatisDao = SpringContextBean.getBean("simpleMybatisDao",SimpleMybatisDao.class);
            Integer dataCount = simpleMybatisDao.selectOne("test.queryCount", qParams, Integer.class);
            List<Map> smsRecordList = simpleMybatisDao.selectList("test.query", qParams, Map.class);
            if (smsRecordList == null) {
                result.put("status",-1);
                result.put("message","无记录！");
            } else {
                result.put("status", 0);
                result.put("message", "ok");
                result.put("data", smsRecordList);
                result.put("total", dataCount);
                result.put("count", smsRecordList.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取失败：{}", e.getMessage());
        }
        return result.toString();
    }

    @GetMapping("/s")
    public void TEST(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        testService.queryOne();

    }
}
