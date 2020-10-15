package cn.keep.coding.base.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 加密工具类
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 */
public class EncryptUtil {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private String token;
    private String algorithm;
    private long timeout;
    private boolean defaultUrlCheck = true;

    public EncryptUtil(String token, String algorithm, long timeout) {
        this.token = token;
        this.algorithm = algorithm;
        this.timeout = timeout;
    }

    public EncryptUtil(String token) {
        this(token, "SHA-256", 10000);
    }

    /**
     * 生成签名
     * @param url
     * @return
     */
    public String genSign(String url) {
        JSONObject params = new JSONObject();
        return genSign(url, params, defaultUrlCheck);
    }

    /**
     * 生成签名
     * @param url
     * @param isUrlCheck
     * @return
     */
    public String genSign(String url, boolean isUrlCheck) {
        JSONObject params = new JSONObject();
        return genSign(url, params, isUrlCheck);
    }

    /**
     * 生成签名
     * @param params
     * @param url
     * @return
     */
    public String genSign(String url, JSONObject params) {
        return genSign(url, params, defaultUrlCheck);
    }

    /**
     * 生成签名
     * @param url
     * @param params
     * @param isUrlCheck
     * @return
     */
    public String genSign(String url, JSONObject params, boolean isUrlCheck) {
        String timeStamp = String.valueOf(new Date().getTime());
        return genSign(url, params, timeStamp, defaultUrlCheck);
    }

    /**
     * 生成签名
     * @param url
     * @param params
     * @param timeStamp
     * @return
     */
    public String genSign(String url, JSONObject params, String timeStamp) {
        return genSign(url, params, timeStamp, defaultUrlCheck);
    }

    /**
     * 生成签名
     * @param params
     * @param timeStamp
     * @return
     */
    public String genSign(JSONObject params, String timeStamp) {
        String url = "http://hereisnoturl.com";
        return genSign(url, params, timeStamp, false);
    }

    /**
     * 生成签名
     * @param params
     * @return
     */
    public String genSign(JSONObject params) {
        String url = "http://hereisnoturl.com";
        String timeStamp = String.valueOf(new Date().getTime());
        return genSign(url, params, timeStamp, false);
    }

    /**
     * 生成签名
     * @param url
     * @param params
     * @param timeStamp
     * @param isUrlCheck
     * @return
     */
    public String genSign(String url, JSONObject params, String timeStamp, boolean isUrlCheck) {
        String sign = null;
        if(url == null || "".equals(url)) {
            return null;
        }
        JSONObject urlParams = getQueryParams(url);
        if(urlParams != null && urlParams.size() > 0) {
            for (Map.Entry<String, Object> entry : urlParams.entrySet()) {
                params.put(entry.getKey(), entry.getValue());
            }
        }
        int in = url.indexOf("?");
        url = in > -1 ? url.substring(0, in) : url;
        int pSize = 3, arrCount = 2;
        if(!isUrlCheck) {
            pSize--;
            arrCount--;
        }
        if(params != null) {
            pSize = pSize + params.size();
        }
        String[] arr = new String[pSize];
        arr[0] = timeStamp;
        arr[1] = token;
        if(isUrlCheck) {
            arr[2] = url;
        }
        if(params != null && params.size() > 0) {
            String value = null, temp = null;
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                temp = String.valueOf(entry.getValue());
                value = temp;
                if(temp.startsWith("{")) {
                    try {
                        value = JSONObject.toJSONString(JSONObject.parseObject(temp), SerializerFeature.SortField.MapSortField);
                    } catch (JSONException ex) { }
                }
                if(temp.startsWith("[")) {
                    try {
                        value = JSONObject.toJSONString(JSONObject.parseArray(temp), SerializerFeature.SortField.MapSortField);
                    } catch (JSONException ex) { }
                }
                arr[++arrCount] = value;
            }
        }
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(algorithm);
            md.update(content.toString().getBytes("UTF-8"));
            sign = Hex.encodeHexString(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }
        return timeStamp + sign;
    }

    /**
     * 校验签名
     * @param url
     * @return
     */
    public JSONObject checkSign(String url) {
        JSONObject params = new JSONObject();
        return checkSign(url, params, defaultUrlCheck);
    }

    /**
     * 校验签名
     * @param url
     * @param isUrlCheck
     * @return
     */
    public JSONObject checkSign(String url, boolean isUrlCheck) {
        JSONObject params = new JSONObject();
        return checkSign(url, params, isUrlCheck);
    }

    /**
     * 校验签名
     * @param url
     * @param params
     * @return
     */
    public JSONObject checkSign(String url, JSONObject params) {
        return checkSign(url, params, defaultUrlCheck);
    }

    /**
     * 校验签名
     * @param url
     * @param params
     * @param isUrlCheck
     * @return
     */
    public JSONObject checkSign(String url, JSONObject params, boolean isUrlCheck) {
        JSONObject result = new JSONObject();
        if(params == null) {
            params = new JSONObject();
        }
        JSONObject urlParams = getQueryParams(url);
        if(urlParams != null && urlParams.size() > 0) {
            for (Map.Entry<String, Object> entry : urlParams.entrySet()) {
                params.put(entry.getKey(), entry.getValue());
            }
        }
        int in = url.indexOf("?");
        url = in > -1 ? url.substring(0, in) : url;
        String signStr = params.getString("sign");
        if(StringUtil.isBlank(signStr)) {
            result.put("status", -1);
            result.put("message", "sign miss");
            return result;
        }
        if(signStr.length() != 77) {
            result.put("status", -1);
            result.put("message", "sign length illegal");
            return result;
        }
        try {
            String timeStampStr = signStr.substring(0, 13);
            long timeStamp = Long.valueOf(timeStampStr);
            if(new Date().getTime() - timeStamp > timeout) {
                result.put("status", -1);
                result.put("message", "sign expire");
                return result;
            }
            params.remove("sign");
            String genSign = genSign(url, params, timeStampStr, isUrlCheck);
            if(signStr.equals(genSign)) {
                result.put("status", 0);
                result.put("message", "ok");
            } else {
                result.put("status", -1);
                result.put("message", "sign illegal");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            result.put("status", -1);
            result.put("message", "sign illegal!");
        }
        return result;
    }

    /**
     * 获取URL参数
     * @param url
     * @return
     */
    private JSONObject getQueryParams(String url) {
        try {
            JSONObject params = new JSONObject();
            String[] urlParts = url.split("\\?");
            if (urlParts.length > 1) {
                String query = urlParts[1];
                for (String param : query.split("&")) {
                    String[] pair = param.split("=");
                    String key = URLDecoder.decode(pair[0], "UTF-8");
                    String value = "";
                    if (pair.length > 1) {
                        value = URLDecoder.decode(pair[1], "UTF-8");
                    }
                    params.put(key, value);
                }
            }
            return params;
        } catch (UnsupportedEncodingException ex) {
            throw new AssertionError(ex);
        }
    }

    public static void main(String[] args) {
        /*EncryptUtil enc = new EncryptUtil("27688ab70a56db714b59a6ebc79b8509a1f81629ce8edc743e1bc23e2446573f");
        JSONObject params = new JSONObject();
        params.put("gnw_appid", "437EC0AC7F0000015E2BBF4849643C93");
        params.put("version", "1.0.0");
        params.put("hash", "5d5e38b87f17fb2e2dbd83931d8079883c7aaf5700f51716ce4932872a436d3a");
        String url = "http://wechat-dev.zhixike.net/ps/pay/alipay/send";
        String timestampStr = "1568170376000";
        String sign = enc.genSign(url, params, timestampStr, false);
        System.out.println(sign);*/

        /*EncryptUtil enc = new EncryptUtil("27688ab70a56db714b59a6ebc79b8509a1f81629ce8edc743e1bc23e2446573f");
        JSONObject params = new JSONObject();
        params.put("gnw_appid", "437EC0AC7F0000015E2BBF4849643C93");
        params.put("version", "1.0.0");
        params.put("trade_type", "wap");
        params.put("total_amount", 0.01);
        params.put("callback_url", "http://172.168.30.63:8081/bbx-version-manage-v2/system/call");
        params.put("return_url", "http://www.baidu.com");
        params.put("order_desc", "乐扣水杯");
        String url = "http://wechat-dev.zhixike.net/ps/pay/alipay/send";
        String sign = enc.genSign(url, params, false);
        System.out.println(sign);*/


        /*String s1 = "{\"app_token\":\"eyJhbGciOiJIUzI1NiJ9.eyJBUFBfVE9LRU46IjoiMTMwODg4MTQzMTFfTEpSc2xzIiwiZXhwIjoxNTQ1MTMzMjk0fQ.p9JEYOmSywbmSsoA6zi36FoPoGiEV9oGYGI99xVUC0g\",\"batch_time\":[{\"rule_id\":\"\",\"enabled_time\":\"3600\",\"what_day\":\"1\",\"time_parts\":[{\"end_time\":\"08:00\",\"begin_time\":\"06:00\"}]},{\"rule_id\":\"\",\"enabled_time\":\"3600\",\"what_day\":\"2\",\"time_parts\":[{\"end_time\":\"08:00\",\"begin_time\":\"06:00\"}]},{\"rule_id\":\"\",\"enabled_time\":\"3600\",\"what_day\":\"3\",\"time_parts\":[{\"end_time\":\"08:00\",\"begin_time\":\"06:00\"}]},{\"rule_id\":\"\",\"enabled_time\":\"3600\",\"what_day\":\"4\",\"time_parts\":[{\"end_time\":\"08:00\",\"begin_time\":\"06:00\"}]},{\"rule_id\":\"\",\"enabled_time\":\"3600\",\"what_day\":\"5\",\"time_parts\":[{\"end_time\":\"08:00\",\"begin_time\":\"06:00\"}]}],\"sign\":\"15448733830005d3f55fefe9cdc5ac951123fefda04e067991d43346d2fe34ecedf9744694cdf\",\"child_user_id\":\"A01E2D2DACA83239D8A8A06C\",\"gnw_appid\":\"437EC0AC7F0000015E2BBF4849643C96\",\"source\":\"01\",\"child_device_id\":\"A01E2D2DACA83239D8A8A06C\",\"version\":\"1.0.0\"}";
        String s2 = "{\"source\":\"01\",\"batch_time\":[{\"what_day\":\"1\",\"rule_id\":\"\",\"enabled_time\":\"3600\",\"time_parts\":[{\"end_time\":\"08:00\",\"begin_time\":\"06:00\"}]},{\"what_day\":\"2\",\"rule_id\":\"\",\"enabled_time\":\"3600\",\"time_parts\":[{\"end_time\":\"08:00\",\"begin_time\":\"06:00\"}]},{\"what_day\":\"3\",\"rule_id\":\"\",\"enabled_time\":\"3600\",\"time_parts\":[{\"end_time\":\"08:00\",\"begin_time\":\"06:00\"}]},{\"what_day\":\"4\",\"rule_id\":\"\",\"enabled_time\":\"3600\",\"time_parts\":[{\"end_time\":\"08:00\",\"begin_time\":\"06:00\"}]},{\"what_day\":\"5\",\"rule_id\":\"\",\"enabled_time\":\"3600\",\"time_parts\":[{\"end_time\":\"08:00\",\"begin_time\":\"06:00\"}]}],\"gnw_appid\":\"437EC0AC7F0000015E2BBF4849643C96\",\"app_token\":\"eyJhbGciOiJIUzI1NiJ9.eyJBUFBfVE9LRU46IjoiMTMwODg4MTQzMTFfTEpSc2xzIiwiZXhwIjoxNTQ1MTMzMjk0fQ.p9JEYOmSywbmSsoA6zi36FoPoGiEV9oGYGI99xVUC0g\",\"version\":\"1.0.0\",\"child_device_id\":\"A01E2D2DACA83239D8A8A06C\",\"sign\":\"15448733830005d3f55fefe9cdc5ac951123fefda04e067991d43346d2fe34ecedf9744694cdf\",\"child_user_id\":\"A01E2D2DACA83239D8A8A06C\"}";

        System.out.println(JSONObject.parseObject(s1).toJSONString());
        System.out.println(JSONObject.parseObject(s2).toJSONString());
        System.out.println(JSONObject.toJSONString(JSONObject.parseObject(s2), SerializerFeature.SortField.MapSortField));

        JSONObject p = new JSONObject();
        p.put("b", "b");
        p.put("a", "a");
        p.put("child_user_id", "child_user_id");
        p.put("sign", "sign");

        System.out.println(p.toJSONString());
        for (Map.Entry<String, Object> entry : p.entrySet()) {
            System.out.println(entry.getValue());
        }

        JSONObject params = JSONObject.parseObject(s2);
        String value = null, temp = null;
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            temp = String.valueOf(entry.getValue());
            value = temp;
            System.out.println("temp: " + temp);
            if(temp.startsWith("{")) {
                try {
                    value = JSONObject.toJSONString(JSONObject.parseObject(temp), SerializerFeature.SortField.MapSortField);
                } catch (JSONException ex) {
                    System.out.println("catch ...");
                }
            }
            if(temp.startsWith("[")) {
                try {
                    value = JSONObject.toJSONString(JSONObject.parseArray(temp), SerializerFeature.SortField.MapSortField);
                } catch (JSONException ex) {
                    System.out.println("catch ...");
                }
            }

            System.out.println("value: " + value);
        }*/


        JSONObject params = new JSONObject();
        JSONArray batch_time = new JSONArray();
        JSONObject a1 = new JSONObject();
        a1.put("rule_id", "");
        a1.put("enabled_time", "21600");
        a1.put("what_day", "1");
        JSONArray time_parts = new JSONArray();
        JSONObject b1 = new JSONObject();
        b1.put("end_time", "18:00");
        b1.put("begin_time", "06:00");
        b1.put("flag", "a");
        time_parts.add(b1);

        JSONObject b2 = new JSONObject();
        b2.put("end_time", "13:00");
        b2.put("begin_time", "07:00");
        b2.put("flag", "c");
        time_parts.add(b2);

        JSONObject b3 = new JSONObject();
        b3.put("end_time", "11:00");
        b3.put("begin_time", "04:00");
        b3.put("flag", "b");
        time_parts.add(b3);

        a1.put("time_parts", time_parts);
        batch_time.add(a1);
        params.put("batch_time", batch_time);
        params.put("app_token", "eyJhbGciOiJIUzI1NiJ9.eyJBUFBfVE9LRU46IjoiMTMwODg4MTQzMTFfTEpSc2xzIiwiZXhwIjoxNTQ1MTMzMjk0fQ.p9JEYOmSywbmSsoA6zi36FoPoGiEV9oGYGI99xVUC0g");

        System.out.println(params.toJSONString());
        System.out.println(">>>>>>>>>>>>>>>>");
        System.out.println(JSONObject.toJSONString(params, SerializerFeature.SortField.MapSortField));

        EncryptUtil enc = new EncryptUtil("27688ab70a56db714b59a6ebc79b8509a1f81629ce8edc743e1bc23e2446573f");
        String url = "http://wechat-dev.zhixike.net/ps/pay/alipay/send";
        String timestampStr = "1568170376000";
        String sign = enc.genSign(url, params, timestampStr, false);
        System.out.println(sign);
    }

}
