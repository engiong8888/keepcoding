package cn.keep.coding.push.api.utils.huaweipush;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * 华为http请求工具类
 *
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 */
public class HttpClientUtil {

    public static String httpPost(String httpUrl, String data)
    {
        OutputStream outPut = null;
        HttpURLConnection httpUrlConn = null;
        InputStream in = null;
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try
        {
            System.out.println("huawei HttpClientUtil httpurl:{} "+httpUrl);
            URL url = new URL(httpUrl);
            httpUrlConn = (HttpURLConnection)url.openConnection();
            httpUrlConn.setRequestMethod("POST");
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            httpUrlConn.setConnectTimeout(30000);
            httpUrlConn.setReadTimeout(30000);
            httpUrlConn.connect();

            // POST data
            outPut = httpUrlConn.getOutputStream();
            outPut.write(data.getBytes("UTF-8"));
            outPut.close();

            // read response
            if (httpUrlConn.getResponseCode() < 400) {
                in = httpUrlConn.getInputStream();
            } else {
                in = httpUrlConn.getErrorStream();
            }
            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            in.close();
            in = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.parseObject(buffer.toString());

        } catch (ConnectException ce) {
            ce.printStackTrace();
            System.out.println(ce.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return jsonObject.toJSONString();
    }
}
