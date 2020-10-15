package cn.keep.coding.push.provider.controller;

import cn.keep.coding.base.db.SimpleMybatisDao;
import cn.keep.coding.base.utils.StringUtil;
import cn.keep.coding.push.provider.config.SpringContextBean;
import cn.keep.coding.push.provider.service.MailPushService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 邮件推送
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/push/mail")
public class MailPushController {
    /**
     * 邮件发送
     * @param request
     * @param response
     * @param rParams
     * @return
     */
    @PostMapping("/send")
    @ResponseBody
    private String send(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject rParams){
        JSONObject result = new JSONObject();

        Map<String, String> params = new HashMap<>();
        params.put("to", rParams.getString("to"));
        params.put("subject", rParams.getString("subject"));
        params.put("messageText", rParams.getString("message_text"));
        MailPushService mailPushService = SpringContextBean.getBean("mailPushService", MailPushService.class);

        try{

            String mailStr = result.getString("data");
            if (!StringUtil.isBlank(mailStr)) {
                JSONObject mailConfig = JSONObject.parseObject(mailStr);
                String fromMail = mailConfig.getString("from_mail");
                String fromMailPwd = mailConfig.getString("from_mail_pwd");
                params.put("from_mail", fromMail);
                params.put("from_mail_pwd", fromMailPwd);
                result = mailPushService.send(params);
            } else {
                result.put("status", -1);
                result.put("message", "mail config in redis does not exist");
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", -1);
            result.put("message", e.getMessage());
        }

        return result.toString();
    }

    /**
     * 邮件发送
     * @param request
     * @param response
     * @param rParams
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    private String update(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject rParams){
        JSONObject result = new JSONObject();

        Map<String, String> params = new HashMap<>();
        params.put("to", rParams.getString("to"));
        params.put("subject", rParams.getString("subject"));
        params.put("messageText", rParams.getString("message_text"));
        MailPushService mailPushService = SpringContextBean.getBean("mailPushService", MailPushService.class);

        try{

            String mailStr = result.getString("data");
            if (!StringUtil.isBlank(mailStr)) {
                JSONObject mailConfig = JSONObject.parseObject(mailStr);
                String fromMail = mailConfig.getString("from_mail");
                String fromMailPwd = mailConfig.getString("from_mail_pwd");
                params.put("from_mail", fromMail);
                params.put("from_mail_pwd", fromMailPwd);
                result = mailPushService.update(params);
            } else {
                result.put("status", -1);
                result.put("message", "mail config in redis does not exist");
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", -1);
            result.put("message", e.getMessage());
        }

        return result.toString();
    }


    /**
     * 获取邮件发送记录
     * @param request
     * @param response
     * @param rParams
     * @return
     */
    @PostMapping("/query/record")
    @ResponseBody
    public String getPushMailRecord(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject rParams) {
        JSONObject result = new JSONObject();

        try {

            String limit = rParams.getString("limit");
            JSONObject qParams = new JSONObject();

            if(!"-1".equals(limit)) {
                qParams.put("pos", rParams.getInteger("pos"));
                qParams.put("limit", Integer.valueOf(limit));
            }
            qParams.put("source", rParams.getString("source"));
            qParams.put("to_mail", rParams.getString("to_mail"));
            qParams.put("subject", rParams.getString("subject"));
            qParams.put("remark", rParams.getString("remark"));
            SimpleMybatisDao simpleMybatisDao = SpringContextBean.getBean("simpleMybatisDao", SimpleMybatisDao.class);
            Integer dataCount = simpleMybatisDao.selectOne("push.mail.queryPushMailRecordCount", qParams, Integer.class);
            List<Map> smsRecordList = simpleMybatisDao.selectList("push.mail.queryPushMailRecord", qParams, Map.class);
            if (smsRecordList == null) {
                result.put("status",-1);
                result.put("message","暂无邮件发送记录！");
            } else {
                result.put("status", 0);
                result.put("message", "ok");
                result.put("data", smsRecordList);
                result.put("total", dataCount);
                result.put("count", smsRecordList.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
