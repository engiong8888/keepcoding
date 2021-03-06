package cn.keep.coding.push.api.entity.huaweipush;

/**
 * 华为接口api
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 */
public class HuweiApiConfig {

    public final static String APP_PACKAGE = "com.gnw.huawei.hmssdk";    //app包名

    public final static String NSP_SVC = "openpush.message.api.send"; //华为推送参数，固定为openpush.message.api.send

    //获取token
    public final static String ACCESS_TOKEN = "https://login.cloud.huawei.com/oauth2/v2/token";

    //发送push消息
    public final static String PUSH_SEND = "https://api.push.hicloud.com/pushsend.do?nsp_ctx=NSP_CTX";

    //消息回执
}
