package cn.keep.coding.push.api.utils;

import cn.keep.coding.base.utils.EncryptUtil;
import com.alibaba.fastjson.JSONObject;

/**
 * 描述
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 */
public class runTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        EncryptUtil encUtil = new EncryptUtil("27688ab70a56db714b59a6ebc79b8509a1f81629ce8edc743e1bc23e24465735");
//        String url = "msdev.dev.zhixike.net/ls"+"/rail/get";
        String url = "msdev.dev.zhixike.net/pss"+"/rail/get";
        JSONObject params = new JSONObject();
    /*    params.put("device_id","dev2ice-002");
        params.put("regist_id","133065ffa4e207f4a176");
        params.put("pa_type","001");
        params.put("platform","01");*/
//        params.put("mobile","13178255525");
//        params.put("content","测试内容smstid");
//        params.put("source","01");

//        params.put("phone","13178255525");
//        params.put("source","01");
//        params.put("limit",10);
//        params.put("pos",0);

        //params.put("acc_id","test007");

       /* params.put("to","chengzd@txtws.com");
        params.put("subject","邮件标题");
        params.put("message_text","邮件内容");
        params.put("source","01");*/

//        JSONObject json = new JSONObject();
//        json.put("code","1234");
//        params.put("temp_num","SMS_00");
//        params.put("phone","13178255525");
//        params.put("platform","01");
//        params.put("temp_params",json);

        /*JSONObject json = new JSONObject();
        json.put("code","6666");
        params.put("temp_num","SMS_01");
        params.put("phone","18250785775");
        params.put("platform","01");
        params.put("temp_params",json);*/

//        JSONObject metadata = new JSONObject();
//        metadata.put("user_id","123456");
//        metadata.put("device_id","1234567891234567");
//        params.put("metadata",metadata.toJSONString());
//
//        JSONArray list = new JSONArray();
//        JSONObject listContent = new JSONObject();
//        listContent.put("lat",27.461314);
//        listContent.put("lng",119.165983);
//        listContent.put("csys","GCJ-02");
//        listContent.put("accurate",500);
//        listContent.put("upload_time","1542354832123");
//        list.add(listContent);
//        params.put("list",list.toJSONString());
//        params.put("gnw_appid","437EC0AC7F0000015E2BBF4849643C96");
//        params.put("version","1.0.0");

     /*   params.put("gnw_appid","437EC0AC7F0000015E2BBF4849643C93");
        params.put("version","1.0.0");
        params.put("platform","txtw");
        params.put("total_amount","0.01");
        params.put("order_desc","2019032515402516978");

        params.put("callback_url","https://gl2.ctmsoft.com/mobile/public/notify/wxpay.php");
        params.put("trade_type","MWEB");
        params.put("remark","2019032515402516978");
        params.put("spbill_create_ip","49.94.70.41");

        JSONObject params1 = new JSONObject();
        params1.put("type","IOS");
        params1.put("app_name","格雷盒子家长");
        params1.put("bundle_id","com.txtws.greenbox");

        JSONObject params2 = new JSONObject();
        params2.put("h5_info", params1);
        params.put("scene_info", params2);
*/

//        params.put("gnw_appid","437EC0AC7F0000015E2BBF4849643C95");
//        params.put("version","1.0.0");
//
//        params.put("callback_url","http://order.kf.gwchina.cn/paycenter/jsbank/notify");
//        params.put("total_amount","0.02");
//
//        params.put("trade_target","person");
//        params.put("trade_type","wap");
//        params.put("remark","备注测试建行支付5");
//        params.put("platform","lwtx");
//        params.put("timeout","20190814143005");

//        params.put("gnw_appid","437EC0AC7F0000015E2BBF4849643C95");
//        params.put("version","1.0.0");
//        params.put("platform","glhz_dev");
//        params.put("total_amount","10");
//        params.put("remark","aaa");

        JSONObject json = new JSONObject();
        json.put("test","111");

        params.put("gnw_appid","437EC0AC7F0000015E2BBF4849643C96");
        params.put("version","1.0.0");
        params.put("platform","lwtx");

        params.put("callback_url","http://czd.test.zhixike.net/pay/unionpay/notify/2");
        params.put("total_amount","0.01");
        params.put("trade_type","NATIVE");
        params.put("remark",json.toString());
        params.put("order_desc","测试微信下单");
        params.put("spbill_create_ip","59.61.92.150");


        System.out.println(params.toJSONString());
        String str = encUtil.genSign(url,params,"1571299885000",false);
        System.out.println(str);

//        System.out.println(json.toJSONString());
    }


}
