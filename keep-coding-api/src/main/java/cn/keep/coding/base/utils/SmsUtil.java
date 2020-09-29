package cn.keep.coding.base.utils;


import cn.keep.coding.push.api.entity.Constants;
import cn.keep.coding.push.api.utils.web.WebRequestUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 短信类
 * @author: chengzd
 * @mail chengzd@txtws.com
 * @date: 2018-09-19 13:48
 */
public class SmsUtil {

    private final static String smsHostUrl = "http://www.467890.com/Admin/index.php/Message/send";

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String smsHost = null;
    private String uid = null;
    private String pwd = null;

    public SmsUtil (String smsHost, String uid, String pwd) {
        this.smsHost = smsHost;
        this.uid = uid;
        this.pwd = pwd;
    }

    public SmsUtil (String uid, String pwd) {
        this.uid = uid;
        this.pwd = pwd;
    }

    public JSONObject sendSms (String mobile, String content) {
        JSONObject result = new JSONObject();
        JSONObject jsonObject = new JSONObject ();
        jsonObject.put ("uid", this.uid);
        jsonObject.put ("pwd", this.pwd);
        jsonObject.put ("mobile", mobile);
        jsonObject.put ("content", content);

        logger.info(new StringBuffer("发送短信Http请求，请求：").append(jsonObject.toString()).toString());
        result = WebRequestUtil.httpRequest(smsHostUrl, "POST", jsonObject.toString(), Constants.API_CHARSET);
        logger.info(new StringBuffer("发送短信Http请求，结果：").append(result.toJSONString()).toString());
        return result;
    }

   /* public static void main(String[] args) {
        SmsUtil smsU = new SmsUtil(smsHostUrl, Constants.SMS_UID, Constants.SMS_UID_PWD);
        smsU.sendSms ("13178255525", "验证码：hong，请在5分钟内完成输入，欢迎使用泉港教育！");
    }*/
}
