package cn.keep.coding.push.api.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;

/**
 * 字符串处理工具
 *
 * @author: chengzd
 * @mail chengzd@txtws.com
 * @date: 2019-01-25 10:41
 */
public class StringUtil {
    public static String buildStr (String str, JSONObject jsonObject) {
        Iterator<String> it = jsonObject.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            String value = jsonObject.getString(key);
//            System.out.println("key: "+key+",value:"+value);
            str =  str.replace("${"+key+"}", value);
        }
        return str;
    }

    /*public static void main (String [] args){
        String tempStr = "您的登陆短信验证码是:${top},有效期5分钟。${left}到达";
        String str = "{\"left\":\"51.83772233983162px\",\"top\":\"68.83772233983161px\"}";
        String result = StringUtil.buildStr(tempStr, JSONObject.parseObject(str));
        System.out.println("||||||||"+result);
    }*/
}
