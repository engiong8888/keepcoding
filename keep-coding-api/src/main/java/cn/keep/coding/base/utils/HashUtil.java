package cn.keep.coding.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Hex;

/**
 * 加密工具类
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 */
public class HashUtil {
	
	/**
     * 计算文件的MD5码
     * @param file
     * @return
     */
    public static String getMD5(File file) {
        FileInputStream fis = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            int length = -1;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            return Hex.encodeHexString(md.digest());
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * 计算文本的MD5码
     * @param text
     * @return
     */
    public static String getMD5(String text) {
        byte[] secretBytes = null;
        try {
        	MessageDigest md = MessageDigest.getInstance("MD5");
        	secretBytes = md.digest(text.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
    	for (int i = 0; i < 32 - md5code.length(); i++) {
    		md5code = "0" + md5code;
    	}
    	return md5code;
    }

    /**
     * 得到文件的SHA256码,用于校验
     * @param file
     * @return
     */
    public static String getSHA256(File file) {
        FileInputStream fis = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            fis = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            int length = -1;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            return Hex.encodeHexString(md.digest());
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 得到文本的SHA256码
     * @param str
     * @return
     */
    public static String getSHA256(String str){
    	MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encdeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encdeStr;
    }

    /**
     * 获取文本的哈希值
     * @param str
     * @param algorithm
     * @return
     */
    public static String getHash(String str, String algorithm) {
        MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance(algorithm);
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encdeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encdeStr;
    }

    /**
     * 生成加盐的文本
     * @param origin
     * @param salt
     * @param algorithm 哈希加密算法
     * @return
     */
    public static String genSaltStr(String origin, String salt, String algorithm) {
        String saltStr = null;
        int saltLength = salt.length();
        int itemLength = 4;
        int size = saltLength / itemLength;
        if (saltLength % itemLength != 0) {
            size += 1;
        }
        String[] arr = new String[size + 1];
        int endIndex = 0;
        for (int i = 0; i < size; i++) {
            endIndex = (i+1) * itemLength;
            if(endIndex < saltLength) {
                arr[i] = salt.substring(i * itemLength, endIndex);
            } else {
                arr[i] = salt.substring(i * itemLength);
            }
        }
        arr[size] = origin;
        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        saltStr = getHash(sb.toString(), algorithm);
        return saltStr;
    }
    
	/*public static void main(String[] args) {
        String salt = UniqueKeyUtil.getKey(new Date());
        String str = HashUtil.getMD5("123");
        System.out.println(salt);
        System.out.println(str);
        genSaltStr(str, salt, "MD5");
	}*/

}
