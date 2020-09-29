package cn.keep.coding.push.api.utils.web;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;


/** 
 * Web请求工具
 *  
 * @author Shemg
 * @date 2014年6月4日
 */
public class WebRequestUtil {

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
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr, String charset, String ContentType) {
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
        } catch (Exception e) {
        	e.printStackTrace();
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

    /*public static void main(String[] args) {
	    String url = "http://172.168.30.63/wcs/wechat/redpack/expire/check";
	    JSONObject params = new JSONObject();
        params.put("version", "1.0.0");
        EncryptUtil ec = new EncryptUtil("27688ab70a56db714b59a6ebc79b8509a1f81629ce8edc743e1bc23e2446573f");
        params.put("sign", ec.genSign(url, params, false));
        JSONObject result = WebRequestUtil.httpRequest(url, "POST", params.toJSONString(), "UTF-8", "application/json; charset=utf-8");
        System.out.println(result.toJSONString());
    }*/

}
