package cn.keep.coding.utils;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.*;
import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;

/**
 * Web请求工具
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 */
public class WebRequestUtil {

    public final static String API_CHARSET 							= "UTF-8";

    private Logger logger = LoggerFactory.getLogger(getClass());



    /**
	 * https请求，返回JSON对象
	 * @param requestUrl
	 * @param requestMethod
	 * @param outputStr
	 * @param charset
	 * @return
	 */
	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr, String charset) {  
        JSONObject jsonObject = null;  
        StringBuffer buffer = new StringBuffer();  
        try {  
            TrustManager[] tm = { new MyX509TrustManager() };  
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
            sslContext.init(null, tm, new SecureRandom());
            SSLSocketFactory ssf = sslContext.getSocketFactory();  
            URL url = new URL(requestUrl); 
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);  
            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            httpUrlConn.setRequestMethod(requestMethod);  
            httpUrlConn.setConnectTimeout(10 * 1000);
            httpUrlConn.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
  
            if ("GET".equalsIgnoreCase(requestMethod))  
                httpUrlConn.connect();  
  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                outputStream.write(outputStr.getBytes(charset));  
                outputStream.close();  
            }  
  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();  
            jsonObject = JSONObject.parseObject(buffer.toString());  
        } catch (ConnectException ce) { 
        	ce.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }  
        return jsonObject;  
    }
	
	/**
	 * https请求，返回JSON对象
	 * @param requestUrl
	 * @param requestMethod
	 * @param outputStr
	 * @param charset
	 * @param ContentType
	 * @return
	 */
	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr, String charset, String ContentType) {  
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();  
        try {  
            TrustManager[] tm = { new MyX509TrustManager() };  
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
            sslContext.init(null, tm, new SecureRandom());
            SSLSocketFactory ssf = sslContext.getSocketFactory();  
            URL url = new URL(requestUrl); 
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);  
            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            httpUrlConn.setRequestMethod(requestMethod);  
            httpUrlConn.setConnectTimeout(10 * 1000);
            httpUrlConn.setRequestProperty("Content-Type", ContentType);
  
            if ("GET".equalsIgnoreCase(requestMethod))  
                httpUrlConn.connect();  
  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                outputStream.write(outputStr.getBytes(charset));  
                outputStream.close();  
            }  
  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();  
            jsonObject = JSONObject.parseObject(buffer.toString());  
        } catch (ConnectException ce) { 
        	ce.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }  
        return jsonObject;  
    } 
	
	/**
	 * https请求，返回字符串
	 * @param requestUrl
	 * @param requestMethod
	 * @param outputStr
	 * @param charset
	 * @return
	 */
	public static String httpsRequestStr(String requestUrl, String requestMethod, String outputStr, String charset) {
        StringBuffer buffer = new StringBuffer();  
        try {  
            TrustManager[] tm = { new MyX509TrustManager() };  
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
            sslContext.init(null, tm, new SecureRandom());
            SSLSocketFactory ssf = sslContext.getSocketFactory();  
            URL url = new URL(requestUrl); 
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);  
            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            httpUrlConn.setRequestMethod(requestMethod);  
            httpUrlConn.setConnectTimeout(10 * 1000);
            httpUrlConn.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
  
            if ("GET".equalsIgnoreCase(requestMethod))  
                httpUrlConn.connect();  
  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                outputStream.write(outputStr.getBytes(charset));  
                outputStream.close();  
            }  
  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();  
        } catch (ConnectException ce) { 
        	ce.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }  
        return buffer.toString();  
	}
	
	/**
	 * https请求(使用证书)，返回字符串
	 * @param requestUrl
	 * @param requestMethod
	 * @param outputStr
	 * @param charset
	 * @param certPath
	 * @param certPwd
	 * @return
	 */
	public static String httpsRequestStrUseCert(String requestUrl, String requestMethod, String outputStr, String charset, String certPath, String certPwd) {
        StringBuffer buffer = new StringBuffer();  
        try {  
        	KeyStore clientStore = KeyStore.getInstance("PKCS12");
        	clientStore.load(new FileInputStream(certPath), certPwd.toCharArray());
        	KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        	kmf.init(clientStore, certPwd.toCharArray());
        	KeyManager[] kms = kmf.getKeyManagers();
            TrustManager[] tm = { new MyX509TrustManager() };  
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kms, tm, new SecureRandom());  
            SSLSocketFactory ssf = sslContext.getSocketFactory();  
            URL url = new URL(requestUrl); 
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);  
            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            httpUrlConn.setRequestMethod(requestMethod);  
            httpUrlConn.setConnectTimeout(10 * 1000);
            httpUrlConn.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
  
            if ("GET".equalsIgnoreCase(requestMethod)) {
            	httpUrlConn.connect();  
            }
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                outputStream.write(outputStr.getBytes(charset));  
                outputStream.close();  
            }  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();  
        } catch (ConnectException ce) { 
        	ce.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }  
        return buffer.toString();  
	}
	
	/**
	 * http请求，返回JSON对象
	 * @param requestUrl
	 * @param requestMethod
	 * @param outputStr
	 * @param charset
	 * @return
	 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr, String charset) {
		JSONObject jsonObject = null;  
        StringBuffer buffer = new StringBuffer();  
        try {   
            URL url = new URL(requestUrl); 
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
  
            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            httpUrlConn.setRequestMethod(requestMethod);  
            httpUrlConn.setConnectTimeout(10 * 1000);
            httpUrlConn.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
  
            if ("GET".equalsIgnoreCase(requestMethod))  
                httpUrlConn.connect();  
  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                outputStream.write(outputStr.getBytes(charset));  
                outputStream.close();  
            }  
  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();  
            jsonObject = JSONObject.parseObject(buffer.toString());  
        } catch (ConnectException ce) { 
        	ce.printStackTrace();
            System.out.println(ce.getMessage());
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println(e.getMessage());
        }  
        return jsonObject;  
	}
	
	/**
	 * http请求，返回JSON对象
	 * @param requestUrl
	 * @param requestMethod
	 * @param outputStr
	 * @param charset
	 * @param ContentType
	 * @return
	 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr, String charset, String ContentType) throws ConnectException,Exception {
		JSONObject jsonObject = null;  
        StringBuffer buffer = new StringBuffer();  
        try {   
            URL url = new URL(requestUrl); 
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
  
            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            httpUrlConn.setRequestMethod(requestMethod);  
            httpUrlConn.setConnectTimeout(10 * 1000);
            httpUrlConn.setRequestProperty("Content-Type", ContentType);
  
            if ("GET".equalsIgnoreCase(requestMethod))  
                httpUrlConn.connect();  
  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                outputStream.write(outputStr.getBytes(charset));  
                outputStream.close();  
            }  
  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();  
            jsonObject = JSONObject.parseObject(buffer.toString());  
        } catch (ConnectException ce) { 
        	ce.printStackTrace();
            throw ce;
        } catch (Exception e) {
        	e.printStackTrace();
            jsonObject.put("status", -1);
            jsonObject.put("message", e.getMessage());
        }  
        return jsonObject;  
	}
	
	/**
	 * http请求，返回字符串
	 * @param requestUrl
	 * @param requestMethod
	 * @param outputStr
	 * @param charset
	 * @return
	 */
	public static String httpRequestStr(String requestUrl, String requestMethod, String outputStr, String charset) {
        StringBuffer buffer = new StringBuffer();  
        try {   
            URL url = new URL(requestUrl); 
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
  
            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            httpUrlConn.setInstanceFollowRedirects(true);
            httpUrlConn.setRequestMethod(requestMethod);  
            httpUrlConn.setConnectTimeout(10 * 1000);
            httpUrlConn.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
  
            if ("GET".equalsIgnoreCase(requestMethod))  
                httpUrlConn.connect();  
  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                outputStream.write(outputStr.getBytes(charset)); 
                outputStream.flush();
                outputStream.close();  
            }  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset); 
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();  
        } catch (ConnectException ce) { 
        	ce.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }  
        return buffer.toString();  
	}
	
	/**
	 * http请求，返回字符串
	 * @param requestUrl
	 * @param requestMethod
	 * @param outputStr
	 * @param charset
	 * @param ContentType
	 * @return
	 */
	public static String httpRequestStr(String requestUrl, String requestMethod, String outputStr, String charset, String ContentType) {
        StringBuffer buffer = new StringBuffer();  
        try {   
            URL url = new URL(requestUrl); 
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
  
            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            httpUrlConn.setInstanceFollowRedirects(true);
            httpUrlConn.setRequestMethod(requestMethod);  
            httpUrlConn.setConnectTimeout(10 * 1000);
            httpUrlConn.setRequestProperty("Content-Type", ContentType);
  
            if ("GET".equalsIgnoreCase(requestMethod))  
                httpUrlConn.connect();  
  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                outputStream.write(outputStr.getBytes(charset)); 
                outputStream.flush();
                outputStream.close();  
            }  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset); 
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();  
        } catch (ConnectException ce) { 
        	ce.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }  
        return buffer.toString();  
	}
	
	/**
	 * 模拟form-data请求表单数据（文本、文件）
	 * @param requestUrl 请求地址
	 * @param textMap 文本信息
	 * @param fileMap 文件信息
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static JSONObject postFormData(String requestUrl, Map<String, String> textMap, Map<String, MultipartFile> fileMap) {
		JSONObject result = new JSONObject();
		HttpURLConnection conn = null;
		try {
            final String newLine = "\r\n";  
            final String boundaryPrefix = "--";  
            String BOUNDARY = "----------" + System.currentTimeMillis(); 
            URL url = new URL(requestUrl);  
            conn = (HttpURLConnection) url.openConnection();  
            conn.setRequestMethod("POST");  
            conn.setDoOutput(true);  
            conn.setDoInput(true);  
            conn.setUseCaches(false);  
            conn.setRequestProperty("connection", "Keep-Alive");  
            conn.setRequestProperty("Charsert", "UTF-8");  
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);  
            OutputStream out = new DataOutputStream(conn.getOutputStream());  
            StringBuffer sb = new StringBuffer(); 
            if(textMap != null) {
            	Iterator iter = textMap.entrySet().iterator();
            	while (iter.hasNext()) {
            		Map.Entry entry = (Map.Entry) iter.next();
            		String inputName = (String) entry.getKey();
            		String inputValue = (String) entry.getValue();
            		if (inputValue == null) {
            			continue;
            		}
            		sb.append(boundaryPrefix).append(BOUNDARY).append(newLine);
            		sb.append("Content-Disposition: form-data;name=\"").append(inputName).append("\"").append(newLine);
            		sb.append("Content-Type:text/plain; charset=UTF-8");
                    sb.append(newLine).append(newLine);
                    sb.append(inputValue).append(newLine);
            	}
            	out.write(sb.toString().getBytes());
            }
            if(fileMap != null) {
            	Iterator iter = fileMap.entrySet().iterator();
            	while (iter.hasNext()) {
            		Map.Entry entry = (Map.Entry) iter.next();
            		String fileName = (String) entry.getKey();
            		MultipartFile inputFile = (MultipartFile) entry.getValue();
            		if (inputFile == null) {
            			continue;
            		}
            		sb = new StringBuffer(); 
            		sb.append(boundaryPrefix).append(BOUNDARY).append(newLine);
            		sb.append("Content-Disposition: form-data;name=\"").append(fileName).append("\";filename=\"")
            		  .append(inputFile.getOriginalFilename()).append("\"").append(newLine);  
                    sb.append("Content-Type:application/octet-stream"); 
                    sb.append(newLine).append(newLine);
                    out.write(sb.toString().getBytes());
                    DataInputStream in = new DataInputStream(inputFile.getInputStream());  
                    byte[] bufferOut = new byte[1024];  
                    int bytes = 0;  
                    while ((bytes = in.read(bufferOut)) != -1) {  
                        out.write(bufferOut, 0, bytes);  
                    }  
                    out.write(newLine.getBytes());  
                    in.close(); 
            	}
            }
            byte[] end_data = new StringBuffer(newLine).append(boundaryPrefix).append(BOUNDARY)
            					.append(boundaryPrefix).append(newLine).toString().getBytes();
            out.write(end_data);  
            out.flush();  
            out.close(); 
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));  
            String line = null;  
            StringBuffer rsb = new StringBuffer();
            while ((line = reader.readLine()) != null) {  
                rsb.append(line);
            }  
            reader.close();
            reader = null;
            result = JSONObject.parseObject(rsb.toString());
        } catch (Exception e) {
            e.printStackTrace();  
        } finally {
        	if(conn != null) {
        		conn.disconnect();
        		conn = null;
        	}
        }
		return result;
	}

    // 从指定的url中获取数据
    //https://www.marinetraffic.com/en/ais/details/ships/shipid:650235/mmsi:414726000/vessel:YU%20MING
    public static String caiHttpsRequest(String requestUrl){
        StringBuffer buffer = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        InputStream inputStream = null;
        HttpsURLConnection httpUrlConn = null;
        // 建立并向网页发送请求
        try {
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(requestUrl);
            // 描述状态
            httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);
            httpUrlConn
                    .setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36)");
            //防止报403错误。
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 请求的类型
            httpUrlConn.setRequestMethod("GET");
            // 获取输入流
            inputStream = httpUrlConn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            // 从输入流读取结果
            buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpUrlConn != null) {
                httpUrlConn.disconnect();
            }
        }
        return buffer.toString();
    }

//    public static void main(String[] args) {
//        StringBuilder result=new StringBuilder();
//        String source ="<!DOCTYPE html><html lang=\"zh-CN\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\"><meta http-equiv=\"Cache-Control\" content=\"no-transform\" /><meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" /><link type=\"text/css\" media=\"all\" href=\"https://www.yugonghf.com/skin/ecms/cache/autoptimize/css/autoptimize_6845d0bcb8491111396421a4a5282656.css\" rel=\"stylesheet\" /><title>新生儿睡觉要注意哪些？爸妈们有必要知晓！ - 育儿知识宝典</title><meta name=\"keywords\" content=\"\" /><meta name=\"description\" content=\"新生儿睡觉要注意哪些?有一个原则：新生儿一定要睡在妈妈身边。这样一方面新生儿会更加安心，因为新生儿听惯了妈妈的心跳声和说话的声音，有妈妈在身边，他们能睡得更加安稳。另一方面，妈妈也更方便对新生儿进行安抚、哺乳。\" /><style type=\"text/css\">.titleDown{font-size:0.85em;margin:-15px 0 10px;color:#999;text-align:center;}.titleDown span{margin-right:10px;}</style><link rel=\"shortcut icon\" href=\"/favicon.ico\"><link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"https://www.yugonghf.com/skin/ecms/img/favicon.png\" /><!--[if lt IE 9]><script src=\"https://www.yugonghf.com/skin/ecms/js/html5-css3.js\"></script><![endif]--><script type='text/javascript' src='https://www.yugonghf.com/skin/ecms/js/jquery/jquery.js?ver=1.11.3'></script><script type='text/javascript' src='https://www.yugonghf.com/skin/ecms/js/jquery/jquery-migrate.min.js?ver=1.2.1'></script><script type='text/javascript' src='https://www.yugonghf.com/skin/ecms/plugins/nix-gravatar-cache/js/main.js?ver=4.3.1'></script><script type='text/javascript' src='https://www.yugonghf.com/skin/ecms/js/jquery.min.js?ver=1.10.1'></script><script type='text/javascript' src='https://www.yugonghf.com/skin/ecms/js/scrollmonitor.js?ver=2018.03.11'></script><script type='text/javascript' src='https://www.yugonghf.com/skin/ecms/js/slides.js?ver=2018.03.11'></script><script type='text/javascript' src='https://www.yugonghf.com/skin/ecms/js/echo.min.js?ver=2018.03.11'></script><script type='text/javascript' src='https://www.yugonghf.com/skin/ecms/js/script.js?ver=2018.03.11'></script><script type='text/javascript' src='https://www.yugonghf.com/skin/ecms/js/fancybox.js?ver=2018.03.11'></script><script type='text/javascript' src='https://www.yugonghf.com/skin/ecms/js/comments-ajax-qt.js?ver=2018.03.11'></script><script type='text/javascript' src='https://www.yugonghf.com/e/data/js/ajax.js'></script><link rel='canonical' href='https://www.yugonghf.com/yuer/1sui/382.html' /></head><body class=\"single single-post postid-1 single-format-standard\"><div id=\"page\" class=\"hfeed site\"><header id=\"masthead\" class=\"site-header\"><nav id=\"top-header\"><div class=\"top-nav\"><div id=\"user-profile\"> 欢迎光临！ <span class=\"nav-set\"> <span class=\"nav-login\"><script src=\"/e/member/login/loginjsd.php\"></script></span> </span> </div><div class=\"menu-%e5%a4%b4%e9%83%a8-container\"><ul id=\"menu-%e5%a4%b4%e9%83%a8\" class=\"top-menu\"><li id=\"menu-item\" class=\"\"><span class=\"font-text\">小分类</span></li><li id=\"menu-item\" class=\"\"><a href=\"http://www.yugonghf.com/yuer/1sui/\">0-1岁教育</a></li><li id=\"menu-item\" class=\"\"><a href=\"http://www.yugonghf.com/yuer/2sui/\">1-2岁教育</a></li><li id=\"menu-item\" class=\"\"><a href=\"http://www.yugonghf.com/yuer/3sui/\">2-3岁教育</a></li><li id=\"menu-item\" class=\"\"><a href=\"http://www.yugonghf.com/yuer/6sui/\">3-6岁教育</a></li></ul></div></div></nav><div id=\"menu-box\"><div id=\"top-menu\"> <span class=\"nav-search\"> <i class=\"fa fa-search\"> </i> </span><hgroup class=\"logo-site\"><p class=\"site-title\"> <a href=\"https://www.yugonghf.com/\"> <img src=\"/skin/ecms/img/logo.png\" alt=\"育儿知识宝典\" /></a> </p></hgroup><span class=\"mobile-login\"><script src=\"/e/member/login/loginjsm.php\"></script></span><div id=\"site-nav-wrap\"><div id=\"sidr-close\"> <a href=\"#sidr-close\" class=\"toggle-sidr-close\">×</a> </div><nav id=\"site-nav\" class=\"main-nav\"> <a href=\"#sidr-main\" id=\"navigation-toggle\" class=\"bars\"> <i class=\"fa fa-bars\"> </i> </a><div class=\"menu-%e4%b8%bb%e5%af%bc%e8%88%aa-container\"><ul id=\"menu-%e4%b8%bb%e5%af%bc%e8%88%aa\" class=\"down-menu nav-menu\">      <li class=\"\"><a rel=\"nofollow\" href=\"/\"><i class=\"fa fa-home\"></i> 首页</a></li>        <li class=\"current-menu-item\"><a href=\"https://www.yugonghf.com/yuer/\">  育儿常识</a><ul class=\"sub-menu\"><li><a href=\"https://www.yugonghf.com/yuer/ysxs/\">  0-1岁教育</a></li><li><a href=\"https://www.yugonghf.com/yuer/2sui/\">  1-2岁教育</a></li><li><a href=\"https://www.yugonghf.com/yuer/3sui/\">  2-3岁教育</a></li><li><a href=\"https://www.yugonghf.com/yuer/6sui/\">  3-6岁教育</a></li></ul></li><li class=\"\"><a href=\"https://www.yugonghf.com/bbjk/\">  宝宝健康</a><ul class=\"sub-menu\"><li><a href=\"https://www.yugonghf.com/bbjk/yyezn/\">  婴幼儿照护</a></li><li><a href=\"https://www.yugonghf.com/bbjk/fspu/\">  副食品食谱</a></li><li><a href=\"https://www.yugonghf.com/bbjk/bnxa/\">  宝宝牙齿保健</a></li><li><a href=\"https://www.yugonghf.com/bbjk/prnq/\">  哺乳专区</a></li></ul></li><li class=\"\"><a href=\"https://www.yugonghf.com/czjy/\">  成长教养</a><ul class=\"sub-menu\"><li><a href=\"https://www.yugonghf.com/czjy/bbvz/\">  宝宝成长</a></li><li><a href=\"https://www.yugonghf.com/czjy/vvxp/\">  聪明教养</a></li><li><a href=\"https://www.yugonghf.com/czjy/iirre/\">  亲子共读</a></li><li><a href=\"https://www.yugonghf.com/czjy/qzlvs/\">  亲子旅游</a></li><li><a href=\"https://www.yugonghf.com/czjy/diynn/\">  DIY好物</a></li></ul></li><li class=\"\"><a href=\"https://www.yugonghf.com/zj/\">  早期教育</a><ul class=\"sub-menu\"><li><a href=\"https://www.yugonghf.com/zj/gs/\">  少儿故事</a></li><li><a href=\"https://www.yugonghf.com/zj/yue/\">  幼儿园知识</a></li><li><a href=\"https://www.yugonghf.com/zj/yse/\">  育儿心得</a></li></ul></li></ul></div></nav></div></div></div></header><div id=\"main-search\"><div id=\"searchbar\"><form onsubmit=\"return checkSearchForm()\" method=\"post\" name=\"searchform\" id=\"searchform\" action=\"/e/search/index.php\">          <input type=\"hidden\" value=\"title\" name=\"show\">          <input type=\"hidden\" value=\"1\" name=\"tempid\">          <input type=\"hidden\" value=\"news\" name=\"tbname\">          <input name=\"mid\" value=\"1\" type=\"hidden\"><input type=\"text\" value=\"\" name=\"keyboard\" id=\"s\" placeholder=\"输入搜索内容\" required /><button type=\"submit\" name=\"submit\" id=\"searchsubmit\">搜索</button></form></div><div id=\"searchbar\"><form id=\"searchform\" target=\"_blank\" action=\"http://zhannei.baidu.com/cse/site\"><input class=\"swap_value\" placeholder=\"输入站内搜索关键词\" name=\"q\"> <button type=\"submit\" id=\"searchsubmit\">百度</button><input type=\"hidden\" name=\"cc\" value=\"libusi.com\"><input type=\"hidden\" name=\"ie\" value=\"utf-8\"></form><!-- 请将网址（libusi.com）改为自已的或者“不写入缓存”就关闭了 --></div><div id=\"searchbar\"><form method=\"get\" id=\"searchform\" action=\"\"> <input class=\"swap_value\" id=\"haosou\" placeholder=\"输入好搜站内搜索关键词\" onkeydown=\"if(event.keyCode==13){return Search('haosou');}\"> <button type=\"submit\" id=\"searchsubmit\" onClick=\"return Search('haosou');\">好搜</button></form></div><script type=\"text/javascript\">function Search(type){ if (type==\"haosou\") { var value=$(\"#haosou\").val()||\"\"; window.open(\"http://www.haosou.com/s?q=\"+value+\"+site%3Alibusi.com\"); } return false;}</script><!-- 请将网址（libusi.com）改为自已的或者“不写入缓存”就关闭了 --></div><div class=\"clear\"> </div></div><nav class=\"breadcrumb\"> <a href=\"https://www.yugonghf.com\" rel=\"bookmark\" >育儿知识宝典</a> &gt;  <a href=\"https://www.yugonghf.com/yuer/1sui/382.html\" rel=\"bookmark\" >新生儿睡觉要注意哪些？爸妈们有必要知晓！</a> </nav><div id=\"content\" class=\"site-content\"><div class=\"clear\"> </div><div id=\"primary\" class=\"content-area\"><main id=\"main\" class=\"site-main\" role=\"main\"><article id=\"post-382\" class=\"post-382 post type-post status-publish format-standard hentry category-ality-original tag-ality-original\"><header class=\"entry-header\"><h1 class=\"entry-h1\">新生儿睡觉要注意哪些？爸妈们有必要知晓！</h1></header><div class=\"titleDown\"><span><i class=\"fa fa-clock-o\"></i> 日期：2020-04-28 23:56:10</span><span><i class=\"fa fa-user\"></i> 作者：mingyue</span><span><i class=\"fa fa-eye\"></i> 浏览：<script src=\"https://www.yugonghf.com/e/public/ViewClick/?classid=9&id=382&addclick=1\"></script> 次</span><span><a href=\"https://www.yugonghf.com/yuer/1sui/382.html#comments\"><i class=\"fa fa-comments-o\"></i>  查看评论</a></span><span><a target=\"_blank\" href=\"/e/member/fava/add/?classid=9&id=382\"><i class=\"fa fa-heart\"></i> 加入收藏</a></span></div><hr><div class=\"entry-content\"><div class=\"single-content\"><div class=\"ad-pc ad-site\"></div><p><strong>新生儿睡觉要注意哪些</strong>?有一个原则：新生儿一定要睡在妈妈身边。这样一方面新生儿会更加安心，因为新生儿听惯了妈妈的心跳声和说话的声音，有妈妈在身边，他们能睡得更加安稳。另一方面，妈妈也更方便对新生儿进行安抚、哺乳。<br />&nbsp;</p><p style=\"text-align: center;\"><img alt=\"新生儿睡觉要注意哪些？爸妈们有必要知晓！\" src=\"https://www.yugonghf.com/d/file/yuer/1sui/d81385570ba8e1e8b6a2a006d22c0a0f.jpg\" /><br />&nbsp;</p><p><span style=\"color:#FF0000;\">1、新生儿应该睡婴儿床或有单独加护栏的大床</span><br />&nbsp;</p><p>新生儿出生后几个月很快就能自己翻身，这时睡觉就涉及一个安全问题：新生儿会不会掉落床?因为新生儿身体还没生长成熟，所以很怕摔落的时候伤到头部、颈部。<br />&nbsp;</p><p>所以当新生儿会自己翻身之后，父母如果不在新生儿身边时，一定要让他睡安全的婴儿床，或者是有护栏的大床，防止他滚落下来。<br />&nbsp;</p><p><span style=\"color:#FF0000;\">2、新生儿别睡在爸爸妈妈中间</span><br />&nbsp;</p><p>许多年轻父母会在睡觉时让新生儿睡两人中间，似乎这样又甜蜜又安全。其实从科学的角度来讲，这样是不合理的。一方面，新生儿睡在爸爸妈妈中间，可能在翻动的时候会不小心被压到。另一方面，大人睡两边会导致空气中二氧化碳增多，新生儿可能会吸入更多混浊空气，对于他们的成长也不利。<br />&nbsp;</p><p>所以，一般别让新生儿睡在爸爸妈妈的中间，让他单独睡一侧或者睡在婴儿床上会更好。<br />&nbsp;</p><p><span style=\"color:#FF0000;\">3、新生儿要睡妈妈旁边</span><br />&nbsp;</p><p>有一个原则：新生儿一定要睡在妈妈身边。这样一方面新生儿会更加安心，因为新生儿听惯了妈妈的心跳声和说话的声音，有妈妈在身边，他们能睡得更加安稳。另一方面，妈妈也更方便对新生儿进行安抚、哺乳。<br />&nbsp;</p><p>具体方法：可以让新生儿的婴儿床放在妈妈床的这一侧，或者干脆让新生儿睡在大床靠近妈妈的一侧，然后在旁边加装防护栏，这样就比较合理。<br />&nbsp;</p><p>以上便是新生儿睡觉要注意哪些的相关介绍，希望对各位年轻的爸爸妈妈们有所帮助。</p> <p><br>本站网站上所有的内容，包括医学建议和其他健康有关的信息，仅提供信息参考目的，不应被视为针对任何情况而特定诊断或治疗计划。如果您对自己的健康或他人的健康有任何疑问，请务必到正规医生寻求直接建议。</p></div><div class=\"clear\"><div class=\"page5\"></div></div><div id=\"social\"><div class=\"social-main\"> <span class=\"like\"> <a href=\"JavaScript:makeRequest('https://www.yugonghf.com/e/public/digg/?classid=9&id=382&dotop=1&doajax=1&ajaxarea=diggnum','EchoReturnedText','GET','');\" title=\"我赞\" class=\"favorite\"><i class=\"fa fa-thumbs-up\"></i>赞 <i class=\"count\" id=\"diggnum\"> <script src=\"https://www.yugonghf.com/e/public/ViewClick/?classid=9&id=382&down=5\"></script></i> </a> </span> <span class=\"shang-p\"> <a href=\"#shang\" id=\"shang-main-p\" title=\"赞助本站\">赏</a> </span> <span class=\"share-s\"> <a href=\"#share\" id=\"share-main-s\" title=\"分享\"> <i class=\"fa fa-share-alt\"> </i>分享</a> </span><div class=\"clear\"> </div></div><div id=\"share\"><div class=\"bdsharebuttonbox\"><a title=\"分享到QQ空间\" href=\"#\" class=\"fa fa-qq\" class=\"bds_qzone\" data-cmd=\"qzone\"></a> <a title=\"分享到新浪微博\" href=\"#\" class=\"fa fa-weibo\" class=\"bds_tsina\" data-cmd=\"tsina\"></a> <a title=\"分享到腾讯微博\" href=\"#\" class=\"fa fa-pinterest-square\" class=\"bds_tqq\" data-cmd=\"tqq\"></a> <a title=\"分享到人人网\" href=\"#\" class=\"fa fa-renren\" class=\"bds_renren\" data-cmd=\"renren\"></a> <a title=\"分享到微信\" href=\"#\" class=\"fa fa-weixin\" class=\"bds_weixin\" data-cmd=\"weixin\"></a> <a title=\"更多\" href=\"#\" class=\"fa fa-plus-square\" class=\"bds_more\" data-cmd=\"more\"></a> </div></div><div id=\"shang\"><div class=\"shang-main\"><h4>支付宝转账赞助</h4> <img title=\"支付宝扫一扫赞助\" src=\"/skin/ecms/img/zhifubaosaoyisaozanzhu.jpg\" /><h4>支付宝扫一扫赞助</h4><h4>微信转账赞助</h4> <img title=\"微信扫一扫赞助\" src=\"/skin/ecms/img/weixinsaoyisaozanzhu.jpg\" /><h4>微信扫一扫赞助</h4><!-- 请改为自已的或者“不写入缓存”就关闭了 --></div></div></div><footer class=\"single-footer\"><ul class=\"single-meta\"><li class=\"comment\"> <a href=\"https://www.yugonghf.com/yuer/1sui/382.html#comments\">查看评论</a></li><li class=\"views\"> 阅读 <script src=\"https://www.yugonghf.com/e/public/ViewClick/?classid=9&id=382&addclick=1\"></script></li><li class=\"r-hide\"> <a href=\"javascript:pr()\" onclick=\"javascript:this.innerHTML=(this.innerHTML=='隐藏边栏'?'显示边栏':'隐藏边栏');\">隐藏边栏</a></li></ul><ul id=\"fontsize\">A+</ul><div class=\"single-cat-tag\"><!--<div class=\"single-cat\">发布日期：2020-04-28 23:56:10&nbsp;&nbsp;所属分类： <a href=\"https://www.yugonghf.com/yuer/ysxs/\" target=\"_blank\">0-1岁教育</a></div>--><div class=\"single-tag\">标签：</div></div></footer><div class=\"clear\"></div></div></article><div class=\"authorbio\"><ul class=\"spostinfo\"><li> <strong>版权声明：</strong>本站原创文章，于2020-04-28 23:56:10，由发表。</li><li> <strong>转载请注明：</strong> <a href=\"https://www.yugonghf.com/yuer/1sui/382.html\" rel=\"bookmark\" title=\"本文固定链接https://www.yugonghf.com/yuer/1sui/382.html\">新生儿睡觉要注意哪些？爸妈们有必要知晓！ |育儿知识宝典</a> <a href=\"#\" onclick=\"copy_code('https://www.yugonghf.com/yuer/1sui/382.html'); return false;\"> +复制链接</a></li></ul></div><div id=\"related-img\"> <div class=\"clear\"> </div></div><div id=\"single-widget\"><aside id=\"related_post-7\" class=\"widget widget_related_post\"><h3 class=\"widget-title\"><div class=\"s-icon\"> </div>热门文章</h3><div id=\"related_post_widget\"><ul><li><span class='li-icon li-icon-1'>1</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/235.html\">2020宝宝几月出生最好？鼠年哪月出生命好？</a></li><li><span class='li-icon li-icon-2'>2</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/278.html\">飞机抱适合多大的婴儿？可以抱多久呢？</a></li><li><span class='li-icon li-icon-3'>3</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/333.html\">新生儿用80毫升的奶瓶合适吗？如果不合适需要</a></li><li><span class='li-icon li-icon-4'>4</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/310.html\">新生儿医保什么时候办最合适？需要准备哪些资</a></li><li><span class='li-icon li-icon-5'>5</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/274.html\">新生儿可以飞机抱姿势睡觉吗？一次抱多久为宜</a></li><li><span class='li-icon li-icon-6'>6</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/261.html\">怎么判断宝宝是肠绞痛还是没吃饱？怎么解决？</a></li><li><span class='li-icon li-icon-7'>7</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/275.html\">新生儿可以飞机抱吗？飞机抱一天几次最好？</a></li><li><span class='li-icon li-icon-8'>8</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/279.html\">新生儿可以飞机抱拍嗝吗？对孩子会有影响吗？</a></li></ul></div><div class=\"clear\"> </div></aside><aside id=\"hot_comment-17\" class=\"widget widget_hot_comment\"><h3 class=\"widget-title\"><div class=\"s-icon\"> </div>最新文章</h3><div id=\"hot_comment_widget\"><ul><li><span class='li-icon li-icon-1'>1</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/382.html\">新生儿睡觉要注意哪些？爸妈们有必要知晓！</a></li><li><span class='li-icon li-icon-2'>2</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/381.html\">宝宝的相貌是谁决定的？主要遗传谁的？</a></li><li><span class='li-icon li-icon-3'>3</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/380.html\">新生儿一出生哭不停？为什么会哭呢？</a></li><li><span class='li-icon li-icon-4'>4</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/379.html\">新生儿需要打哪些疫苗？打疫苗需要注意什么？</a></li><li><span class='li-icon li-icon-5'>5</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/378.html\">新生儿怎么鉴别油耳朵？都有些什么方法呢？</a></li><li><span class='li-icon li-icon-6'>6</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/377.html\">新生儿身高体重标准表，多少为正常值呢？</a></li><li><span class='li-icon li-icon-7'>7</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/373.html\">新生儿视力能看多远？新生儿视力发育过程是怎</a></li><li><span class='li-icon li-icon-8'>8</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/361.html\">刚生的新生儿怎么护理？这3个方面要知晓</a></li></ul></div><div class=\"clear\"> </div></aside><div class=\"clear\"> </div></div><div class=\"ad-pc ad-site\"></div><nav class=\"nav-single\">  <a href=\"https://www.yugonghf.com/yuer/1sui/381.html\" rel=\"prev\"> <span class=\"meta-nav\"> <span class=\"post-nav\"> <i class=\"fa fa-angle-left\"></i>上一篇</span> <br/>宝宝的相貌是谁决定的？主要遗传谁的？</span></a> <div class=\"clear\"></div></nav><nav class=\"nav-single-c\"><nav class=\"navigation post-navigation\" role=\"navigation\"><div class=\"nav-links\"><div class=\"nav-previous\">  <a href=\"https://www.yugonghf.com/yuer/1sui/381.html\" rel=\"prev\"> <span class=\"meta-nav-r\" aria-hidden=\"true\"> <i class=\"fa fa-angle-left\"></i></span> </a></div><div class=\"nav-next\"> </div></div></nav></nav><div id=\"comments\" class=\"comments-area\"><div id=\"respond\" class=\"comment-respond\"><link href=\"/skin/ecmspl/css/pl.css\" rel=\"stylesheet\"><div class=\"showpage\" id=\"plpost\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"  style=\"line-height: 25px; padding: 5px 3px 1px 8px; font-size: 18px;\"><tr><td><strong><font color=\"#333333\">留言与评论（共有 <span id=\"infocommentnumarea\">0</span> 条评论）</font></strong></td></tr></table><script>\t\t  function CheckPl(obj)\t\t  {\t\t  if(obj.saytext.value==\"\")\t\t  {\t\t  alert(\"您没什么话要说吗？\");\t\t  obj.saytext.focus();\t\t  return false;\t\t  }\t\t  return true;\t\t  }\t\t  </script><form action=\"/e/pl/doaction.php\" method=\"post\" name=\"saypl\" id=\"saypl\" onsubmit=\"return CheckPl(document.saypl)\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"plpost\"><tr><td><table width=\"100%\" border=\"0\" cellspacing=\"10\" cellpadding=\"0\"><tr><td><script src=\"https://www.yugonghf.com/e/pl/loginjspl.php\"></script><textarea name=\"saytext\" rows=\"6\" id=\"saytext\" placeholder=\"请遵守互联网相关规定，不要发布广告和违法内容!\"></textarea><script src=\"/d/js/js/plface.js\"></script>&nbsp;&nbsp;&nbsp;<table width='100%' align='left' cellpadding=3 cellspacing=1 bgcolor='#FFF'><tr><td width=\"80%\" height=\"40\" bgcolor=\"#FFFFFF\">验证码：<input name=\"key\" type=\"text\" class=\"inputText\" size=\"16\" /><img src=\"/e/ShowKey/?v=pl\" align=\"absmiddle\" name=\"plKeyImg\" id=\"plKeyImg\" onclick=\"plKeyImg.src='/e/ShowKey/?v=pl&t='+Math.random()\" title=\"看不清楚,点击刷新\" /> </td> <td width=\"20%\" height=\"40\" bgcolor=\"#FFFFFF\"> <input name=\"sumbit\" type=\"submit\" value=\"提交评论\" tabindex=\"6\" style=\"border-radius: 5px;font-size: 16px;background: #00aeff none repeat scroll 0% 0%;border: 0px none;margin: 0px 16px;padding: 1px 16px;height: 33px;line-height: 30px;color: rgb(255, 255, 255);opacity: 0.95;\"><input name=\"id\" type=\"hidden\" id=\"id\" value=\"382\" /><input name=\"classid\" type=\"hidden\" id=\"classid\" value=\"9\" /><input name=\"enews\" type=\"hidden\" id=\"enews\" value=\"AddPl\" /><input name=\"repid\" type=\"hidden\" id=\"repid\" value=\"0\" /><input type=\"hidden\" name=\"ecmsfrom\" value=\"https://www.yugonghf.com/yuer/1sui/382.html\"></td></tr>  </table> </td></tr></table></td></tr></table></form>\t<table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\" bgcolor=\"#FFFFFF\">        <tr>          <td bgcolor=\"#FFFFFF\" id=\"infocommentarea\"></td>        </tr>        </table> <script src=\"https://www.yugonghf.com/e/extend/infocomment/commentajax.php?classid=9&id=382\"></script></div>\t</div></div><div class=\"clear\"> </div></div><div id=\"sidebar\" class=\"widget-area\"><aside id=\"hot_commend-25\" class=\"widget widget_hot_commend\"><h3 class=\"widget-title\"> <i class=\"fa fa-bars\"></i>本站推荐</h3><div id=\"hot\" class=\"hot_commend\"><ul><li><figure class=\"thumbnail\"> <a target=\"_blank\" href=\"https://www.yugonghf.com/wensf/778.html\"><img src=\"https://www.yugonghf.com/e/data/tmp/titlepic/e29480c0bfd1e6741de53743d6a00075.jpg\" alt=\"15条简单的小贴士让宝宝用餐时间不那么混乱\" /></a> </figure><div class=\"hot-title\"><a target=\"_blank\" href=\"https://www.yugonghf.com/wensf/778.html\" rel=\"bookmark\">15条简单的小贴士让宝宝用餐时间不那么混乱</a></div><div class=\"views\">阅读<script src=\"https://www.yugonghf.com/e/public/ViewClick/?classid=10&id=778\"></script></div> <i class=\"fa fa-thumbs-o-up\">&nbsp;3</i></li><li><figure class=\"thumbnail\"> <a target=\"_blank\" href=\"https://www.yugonghf.com/wensf/775.html\"><img src=\"https://www.yugonghf.com/e/data/tmp/titlepic/50e64359334c8897992b0984646fce70.jpg\" alt=\"如果您的宝宝拒绝奶瓶，婴儿奶瓶喂食技巧\" /></a> </figure><div class=\"hot-title\"><a target=\"_blank\" href=\"https://www.yugonghf.com/wensf/775.html\" rel=\"bookmark\">如果您的宝宝拒绝奶瓶，婴儿奶瓶喂食技巧</a></div><div class=\"views\">阅读<script src=\"https://www.yugonghf.com/e/public/ViewClick/?classid=10&id=775\"></script></div> <i class=\"fa fa-thumbs-o-up\">&nbsp;3</i></li><li><figure class=\"thumbnail\"> <a target=\"_blank\" href=\"https://www.yugonghf.com/wensf/773.html\"><img src=\"https://www.yugonghf.com/e/data/tmp/titlepic/0875c102442e5a97063706576f663d6b.jpg\" alt=\"婴儿过渡到吸管或吸管杯的最佳方法\" /></a> </figure><div class=\"hot-title\"><a target=\"_blank\" href=\"https://www.yugonghf.com/wensf/773.html\" rel=\"bookmark\">婴儿过渡到吸管或吸管杯的最佳方法</a></div><div class=\"views\">阅读<script src=\"https://www.yugonghf.com/e/public/ViewClick/?classid=10&id=773\"></script></div> <i class=\"fa fa-thumbs-o-up\">&nbsp;2</i></li><li><figure class=\"thumbnail\"> <a target=\"_blank\" href=\"https://www.yugonghf.com/wensf/772.html\"><img src=\"https://www.yugonghf.com/e/data/tmp/titlepic/43750189fa2ebc004038f5494f1e9911.jpg\" alt=\"简化和享受与小孩子一起用餐的秘密\" /></a> </figure><div class=\"hot-title\"><a target=\"_blank\" href=\"https://www.yugonghf.com/wensf/772.html\" rel=\"bookmark\">简化和享受与小孩子一起用餐的秘密</a></div><div class=\"views\">阅读<script src=\"https://www.yugonghf.com/e/public/ViewClick/?classid=10&id=772\"></script></div> <i class=\"fa fa-thumbs-o-up\">&nbsp;2</i></li><li><figure class=\"thumbnail\"> <a target=\"_blank\" href=\"https://www.yugonghf.com/wensf/769.html\"><img src=\"https://www.yugonghf.com/e/data/tmp/titlepic/762f649903009ea1ae90c57a61d0717b.jpg\" alt=\"为什么需要让宝宝自己喂养？婴儿自我喂养的9大好处\" /></a> </figure><div class=\"hot-title\"><a target=\"_blank\" href=\"https://www.yugonghf.com/wensf/769.html\" rel=\"bookmark\">为什么需要让宝宝自己喂养？婴儿自我喂养的9大好处</a></div><div class=\"views\">阅读<script src=\"https://www.yugonghf.com/e/public/ViewClick/?classid=10&id=769\"></script></div> <i class=\"fa fa-thumbs-o-up\">&nbsp;1</i></li><li><figure class=\"thumbnail\"> <a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/334.html\"><img src=\"https://www.yugonghf.com/e/data/tmp/titlepic/93cb620b34a977176fad77e7b526d759.jpg\" alt=\"新生儿奶瓶买多大容量合适？新生儿奶瓶如何选择？\" /></a> </figure><div class=\"hot-title\"><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/334.html\" rel=\"bookmark\">新生儿奶瓶买多大容量合适？新生儿奶瓶如何选择？</a></div><div class=\"views\">阅读<script src=\"https://www.yugonghf.com/e/public/ViewClick/?classid=9&id=334\"></script></div> <i class=\"fa fa-thumbs-o-up\">&nbsp;2</i></li><li><figure class=\"thumbnail\"> <a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/326.html\"><img src=\"https://www.yugonghf.com/e/data/tmp/titlepic/d640174851c65c2101d3e16c8fabb22e.jpg\" alt=\"冬天新生儿衣服怎么穿几层？宝宝的穿衣顺序图\" /></a> </figure><div class=\"hot-title\"><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/326.html\" rel=\"bookmark\">冬天新生儿衣服怎么穿几层？宝宝的穿衣顺序图</a></div><div class=\"views\">阅读<script src=\"https://www.yugonghf.com/e/public/ViewClick/?classid=9&id=326\"></script></div> <i class=\"fa fa-thumbs-o-up\">&nbsp;0</i></li><li><figure class=\"thumbnail\"> <a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/306.html\"><img src=\"https://www.yugonghf.com/e/data/tmp/titlepic/a2fd472fe137ef929501ffc30a7db193.jpg\" alt=\"哪类体温计更适合新生儿呢？这4种体温计哪种更好？\" /></a> </figure><div class=\"hot-title\"><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/306.html\" rel=\"bookmark\">哪类体温计更适合新生儿呢？这4种体温计哪种更好？</a></div><div class=\"views\">阅读<script src=\"https://www.yugonghf.com/e/public/ViewClick/?classid=9&id=306\"></script></div> <i class=\"fa fa-thumbs-o-up\">&nbsp;1</i></li><li><figure class=\"thumbnail\"> <a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/huaiyun/201.html\"><img src=\"https://www.yugonghf.com/e/data/tmp/titlepic/d0cbf097f937678cfbdebda3e439e605.jpg\" alt=\"妊娠早期孕妇饮食护理，每日重点膳食要点\" /></a> </figure><div class=\"hot-title\"><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/huaiyun/201.html\" rel=\"bookmark\">妊娠早期孕妇饮食护理，每日重点膳食要点</a></div><div class=\"views\">阅读<script src=\"https://www.yugonghf.com/e/public/ViewClick/?classid=8&id=201\"></script></div> <i class=\"fa fa-thumbs-o-up\">&nbsp;0</i></li><li><figure class=\"thumbnail\"> <a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/huaiyun/93.html\"><img src=\"http://www.yugonghf.com/d/file/yuer/huaiyun/f6804ac440621fccac82799e69b35b57.jpg\" alt=\"如何避免早孕引起的营养缺乏，孕妈妈该怎么做？\" /></a> </figure><div class=\"hot-title\"><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/huaiyun/93.html\" rel=\"bookmark\">如何避免早孕引起的营养缺乏，孕妈妈该怎么做？</a></div><div class=\"views\">阅读<script src=\"https://www.yugonghf.com/e/public/ViewClick/?classid=8&id=93\"></script></div> <i class=\"fa fa-thumbs-o-up\">&nbsp;0</i></li><div class=\"clear\"></div></ul></div><div class=\"clear\"></div></aside><div class=\"sidebar-roll\"><aside id=\"advert-4\" class=\"widget widget_advert\"><div id=\"advert_widget\"></div><!--<div class=\"clear\"></div>--></aside></div><!--<aside id=\"categories-18\" class=\"widget widget_categories\"><h3 class=\"widget-title\"> <i class=\"fa fa-bars\"></i>分类目录</h3><ul><li class=\"cat-item\"><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/\" >育儿常识</a></li><li class=\"cat-item\"><a target=\"_blank\" href=\"https://www.yugonghf.com/bbjk/\" >宝宝健康</a></li><li class=\"cat-item\"><a target=\"_blank\" href=\"https://www.yugonghf.com/czjy/\" >成长教养</a></li><li class=\"cat-item\"><a target=\"_blank\" href=\"https://www.yugonghf.com/zj/\" >早期教育</a></li></ul><div class=\"clear\"></div></aside>--><aside id=\"recent_comments-28\" class=\"widget widget_recent_comments\"><h3 class=\"widget-title\"> <i class=\"fa fa-bars\"></i>头条文章</h3><div id=\"message\" class=\"message-widget\"><ul><li><span class='li-icon li-icon-1'>1</span><a target=\"_blank\" href=\"https://www.yugonghf.com/wenxw/649.html\">如何培养孩子大小便自理啊？过来人经验分享</a></li><li><span class='li-icon li-icon-2'>2</span><a target=\"_blank\" href=\"https://www.yugonghf.com/wenxw/648.html\">孩子自理能力差怎么培养？过来人经验分享</a></li><li><span class='li-icon li-icon-3'>3</span><a target=\"_blank\" href=\"https://www.yugonghf.com/wenxw/645.html\">如何养成良好健康习惯，避免不良习惯造成肥胖？</a></li><li><span class='li-icon li-icon-4'>4</span><a target=\"_blank\" href=\"https://www.yugonghf.com/wenxw/643.html\">怎么让宝宝养成良好的生活习惯？爸妈该怎么做？</a></li><li><span class='li-icon li-icon-5'>5</span><a target=\"_blank\" href=\"https://www.yugonghf.com/wenxw/640.html\">哪些玩具可以开发孩子的智力？这9种玩具很适合孩子</a></li><li><span class='li-icon li-icon-6'>6</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/1sui/253.html\">新生儿一般要睡多少个小时？新生儿睡觉正确姿势</a></li><li><span class='li-icon li-icon-7'>7</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/huaiyun/200.html\">孕妇每天饮食搭配，这样组合营养高</a></li><li><span class='li-icon li-icon-8'>8</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/huaiyun/93.html\">如何避免早孕引起的营养缺乏，孕妈妈该怎么做？</a></li><li><span class='li-icon li-icon-9'>9</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/huaiyun/136.html\">引发胎停育的原因是什么？由哪些因素造成？</a></li><li><span class='li-icon li-icon-10'>10</span><a target=\"_blank\" href=\"https://www.yugonghf.com/yuer/huaiyun/134.html\">如何预防宫外孕？应该怎么做才好呢？</a></li></ul></div><div class=\"clear\"></div></aside></div><div class=\"clear\"></div><div class=\"0258b019881f371c\"></div><div class=\"clear\"></div></div><div id=\"footer-widget-box\"><div class=\"footer-widget\"><aside id=\"nav_menu-3\" class=\"widget widget_nav_menu\"><div class=\"menu-%e9%a1%b5%e8%84%9a-container\"><ul id=\"menu-%e9%a1%b5%e8%84%9a\" class=\"menu\"><!-- 请改为自已的或者“不写入缓存”就关闭了 --><li id=\"menu-item\" class=\"menu-item\"><a href=\"http://www.yugonghf.com/yuer/\"><i class=\"fa-indent fa\"></i><span class=\"font-text\">育儿常识</span></a></li><li id=\"menu-item\" class=\"menu-item\"><a href=\"https://www.yugonghf.com/bbjk/yyezn/\"><i class=\"fa-wrench fa\"></i><span class=\"font-text\">婴幼儿照护</span></a></li><li id=\"menu-item\" class=\"menu-item\"><a href=\"https://www.yugonghf.com/bbjk/lgfyu/\"><i class=\"fa-file-code-o fa\"></i><span class=\"font-text\">流感防疫</span></a></li><li id=\"menu-item\" class=\"menu-item\"><a href=\"https://www.yugonghf.com/bbjk/fspu/\"><i class=\"fa-database fa\"></i><span class=\"font-text\">副食品食谱</span></a></li><li id=\"menu-item\" class=\"menu-item\"><a href=\"https://www.yugonghf.com/bbjk/bnxa/\"><i class=\"fa-leaf fa\"></i><span class=\"font-text\">宝宝牙齿保健</span></a></li><li id=\"menu-item\" class=\"menu-item\"><a target=\"_blank\" href=\"https://www.yugonghf.com/bbjk/prnq/\"><i class=\"fa-desktop fa\"></i><span class=\"font-text\">哺乳专区</span></a></li><li id=\"menu-item\" class=\"menu-item\"><a href=\"https://www.yugonghf.com/czjy/bbvz/\"><i class=\"fa-star-half-o fa\"></i><span class=\"font-text\">宝宝成长</span></a></li><li id=\"menu-item\" class=\"menu-item\"><a href=\"https://www.yugonghf.com/czjy/vvxp/\"><i class=\"fa-star-half-o fa\"></i><span class=\"font-text\">聪明教养</span></a></li><li id=\"menu-item\" class=\"menu-item\"><a href=\"https://www.yugonghf.com/czjy/iirre/\"><i class=\"fa-star-half-o fa\"></i><span class=\"font-text\">亲子共读</span></a></li><li id=\"menu-item\" class=\"menu-item\"><a href=\"https://www.yugonghf.com/czjy/qzlvs/\"><i class=\"fa-star-half-o fa\"></i><span class=\"font-text\">亲子旅游</span></a></li><li id=\"menu-item\" class=\"menu-item\"><a href=\"https://www.yugonghf.com/czjy/diynn/\"><i class=\"fa-star-half-o fa\"></i><span class=\"font-text\">DIY好物</span></a></li><li id=\"menu-item\" class=\"menu-item\"><a href=\"https://www.yugonghf.com/yrcz/ceei/\"><i class=\"fa-star-half-o fa\"></i><span class=\"font-text\">选品攻略</span></a></li><li id=\"menu-item\" class=\"menu-item\"><a href=\"https://www.yugonghf.com/yrcz/rtca/\"><i class=\"fa-star-half-o fa\"></i><span class=\"font-text\">育儿福利</span></a></li><li id=\"menu-item\" class=\"menu-item\"><a href=\"https://www.yugonghf.com/jtgx/mmxq/\"><i class=\"fa-star-half-o fa\"></i><span class=\"font-text\">妈咪心情</span></a></li><li id=\"menu-item\" class=\"menu-item\"><a href=\"https://www.yugonghf.com/jtgx/fxgx/\"><i class=\"fa-star-half-o fa\"></i><span class=\"font-text\">夫妻关系</span></a></li><li id=\"menu-item\" class=\"menu-item\"><a href=\"https://www.yugonghf.com/jtgx/iita/\"><i class=\"fa-star-half-o fa\"></i><span class=\"font-text\">宝宝趣闻</span></a></li><li id=\"menu-item\" class=\"menu-item\"><a href=\"https://www.yugonghf.com/xdsq/siei/\"><i class=\"fa-star-half-o fa\"></i><span class=\"font-text\">生活妙招</span></a></li></ul></div><div class=\"clear\"></div></aside><aside id=\"text-30\" class=\"widget widget_text\"><h3 class=\"widget-title\"><div class=\"s-icon\"></div>关于本站</h3><div class=\"textwidget\">（育儿知识宝典为大家提供：育儿知识大全，育儿心得，育儿经验，育儿方法，育儿技巧等育儿常识，为您的孩子提供最新信息，培养优秀接班人！）</div><div class=\"clear\"></div></aside><div class=\"clear\"></div></div></div><footer id=\"colophon\" class=\"site-footer\" role=\"contentinfo\"><div class=\"site-info\"> Copyright <span>&copy;</span>育儿知识宝典版权所有皖ICP备11019200号-1<!-- 统计代码 --><script type='text/javascript' src='/tongji.js'></script><!-- 请改为自已的--><!-- 自动推送开始--><script>(function(){    var bp = document.createElement('script');    var curProtocol = window.location.protocol.split(':')[0];    if (curProtocol === 'https') {        bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';    }    else {        bp.src = 'http://push.zhanzhang.baidu.com/push.js';    }    var s = document.getElementsByTagName(\"script\")[0];    s.parentNode.insertBefore(bp, s);})();</script><!-- 自动推送结束--><span class=\"add-info\"></span></div></footer><ul id=\"scroll\"><li> <a class=\"scroll-t\" title=\"返回顶部\"> <i class=\"fa fa-angle-up\"> </i> </a> </li><li> <a class=\"scroll-c\" title=\"评论\"> <i class=\"fa fa-comment-o\"> </i> </a> </li><li> <a class=\"scroll-b\" title=\"转到底部\"> <i class=\"fa fa-angle-down\"> </i> </a> </li><li> <a class=\"qr\" title=\"二维码\"> <i class=\"fa fa-qrcode\"> </i> </a> </li></ul><span class=\"qr-img\"><img src=\"\" alt=\"扫二维码用手机查看\"/></span><script type=\"text/javascript\" src=\"https://www.yugonghf.com/skin/ecms/js/jquery-ui.min.js\"></script><script type=\"text/javascript\" src=\"https://www.yugonghf.com/skin/ecms/js/qaptcha.jquery.js\"></script><script type='text/javascript' src='https://www.yugonghf.com/skin/ecms/js/superfish.js?ver=2018.03.11'></script><script type='text/javascript' src='https://www.yugonghf.com/skin/ecms/js/3dtag.js?ver=4.3.1'></script><script>window._bd_share_config={\"common\":{\"bdSnsKey\":{},\"bdText\":\"\",\"bdMini\":\"2\",\"bdMiniList\":false,\"bdPic\":\"\",\"bdStyle\":\"1\",\"bdSize\":\"16\"},\"share\":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script></body></html>";
//        String patternStrs="(<div class=\"single-content\"><a.+?>)([^<]*)(</a></div>)";
//        Document document = Jsoup.parse(source);
//
//
//
//        Elements elements = document.select("div.single-content");
//        Elements elements2 = elements.select("p");
//        System.out.println("p标签个数="+elements2.size());
//        String content = "";
//        for (int i =1;i<elements2.size();i++){
//            content += elements2.get(i);
//        }
//
//        System.out.println(content);
//
//    }

}
