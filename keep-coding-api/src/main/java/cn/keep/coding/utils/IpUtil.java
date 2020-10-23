package cn.keep.coding.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * IP工具类
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 */
public class IpUtil {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private IpUtil() {}

    private static class IpUtilsManageHolder {
        private static IpUtil instance = new IpUtil();

    }

    public static IpUtil getInstance() {
        return IpUtilsManageHolder.instance;
    }

    /**
     * 获取本地外网ip
     * @return
     */
    public String getV4IP1(){
        String ip = "";
        String chinaz = "https://www.yugonghf.com/yuer/1sui/381.html";
        StringBuilder inputLine = new StringBuilder();
        String read = "";
        URL url = null;
        HttpURLConnection urlConnection = null;
        BufferedReader in = null;
        try {
            url = new URL(chinaz);
            urlConnection = (HttpURLConnection) url.openConnection();
            in = new BufferedReader( new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
            while((read=in.readLine())!=null){
                inputLine.append(read+"\r\n");
            }
            //System.out.println(inputLine.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            logger.error("getV4IP1 catch MalformedURLException："+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("getV4IP1 catch IOException："+e.getMessage());
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    logger.error("getV4IP1 finally IOException："+e.getMessage());
                }
            }
        }
        Pattern p = Pattern.compile("\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>");
        Matcher m = p.matcher(inputLine.toString());
        if(m.find()){
            String ipstr = m.group(1);
            ip = ipstr;
//            System.out.println(ipstr);
        }
        return ip;
    }

    public String getContent(){
        String ip = "";
        String chinaz = "https://www.yugonghf.com/yuer/1sui/382.html";
        StringBuilder inputLine = new StringBuilder();
        String read = "";
        URL url = null;
        HttpURLConnection urlConnection = null;
        BufferedReader in = null;
        try {
            url = new URL(chinaz);
            urlConnection = (HttpURLConnection) url.openConnection();
            in = new BufferedReader( new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
            while((read=in.readLine())!=null){
                inputLine.append(read+"\r\n");
            }
            //System.out.println(inputLine.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            logger.error("getV4IP1 catch MalformedURLException："+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("getV4IP1 catch IOException："+e.getMessage());
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    logger.error("getV4IP1 finally IOException："+e.getMessage());
                }
            }
        }
        Pattern p = Pattern.compile("\\<div class\\=\"single-content\">(.*?)\\<\\/div>");
        Matcher m = p.matcher(inputLine.toString());
        if(m.find()){
            String ipstr = m.group(1);
            ip = ipstr;
//            System.out.println(ipstr);
        }
        return ip;
    }

    public static void main(String[] args) {
        String ip = IpUtil.getInstance().getContent();
        System.out.println(ip);
    }

}
