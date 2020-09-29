package cn.keep.coding.push.provider.service;

import cn.keep.coding.base.db.SimpleMybatisDao;
import cn.keep.coding.base.utils.UniqueKeyUtil;
import cn.keep.coding.push.provider.config.SpringContextBean;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 邮件推送
 * @author: chengzd
 * @mail chengzd@txtws.com
 * @date: 2018-09-19 9:07
 */
@Service
public class MailPushService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 增加
     * @param params
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public JSONObject send(Map<String, String> params){
        JSONObject result = new JSONObject();

        String recordId = UniqueKeyUtil.getKey(new Date());
        params.put("record_id", recordId);
//        params.put("from_mail", Constants.FROM_MAIL);
        SimpleMybatisDao simpleMybatisDao = SpringContextBean.getBean("simpleMybatisDao", SimpleMybatisDao.class);
        int count = simpleMybatisDao.insert("push.mail.addPushMailRecord", params);
        if(count > 0) {

            result.put("status", 0);
            result.put("message", "success");
        }else{
            result.put("status", -1);
            result.put("message", "mail record insert error");
        }
        return result;
    }

    /**
     * 修改

     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public JSONObject update(Map<String, String> rParams) {
        JSONObject result = new JSONObject();
        Map<String, String> params = new HashMap<String, String>();
        params.put("record_id", rParams.get("record_id"));
        SimpleMybatisDao simpleMybatisDao = SpringContextBean.getBean("simpleMybatisDao", SimpleMybatisDao.class);

        params.put("remark", result.toString());
        simpleMybatisDao.insert("push.mail.updatePushMailRecord",params);

        return result;
    }


}
