package cn.keep.coding.base.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.util.HtmlUtils;

/**
 * 字符串处理工具类
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 *
 */
public class StringUtil {
	
	/**
	 * 判断字符串是否为空对象或是空串，是的话返回true
	 * 
	 */
	public static boolean isBlank(String string){
		boolean bool = false;
		try {
			if(string == null || "".equals(string) || string.trim().length() == 0 || "null".equals(string)){
				bool = true;
			}
		} catch (Exception e) {
			System.out.println("判断字符串是否为空对象或是空串出错!");
			e.printStackTrace();
		}
		return bool;
	}

	/**
	 * 中文encode转码
	 * @param string
	 * @return
	 */
	public static String encodeString(String string){
		String str = string;
		try {
			if(!isBlank(str)){
				str = URLEncoder.encode(str, "UTF-8");
			}
		} catch (Exception e) {
			System.out.println("编码出错");
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * 获得表单提交的数据
	 * 
	 */
	public static String getRequestStr(String string){
		String str = string;
		try {
			if(!isBlank(string)){
				str = new String(string.getBytes("UTF-8"), "UTF-8");
			}
		} catch (Exception e) {
			System.out.println("编码转换出错");
			e.printStackTrace();
		}
		return str;
	}

	public static void main(String[] args) {

		String str = "边唱边喝-round-2";
		String result = "";

		result = encodeString(str);
		System.out.println(result);
	}
	
	/**
	 * 表单提交方式，如果用Post的方式，则需要再进行一次的转编码
	 * 
	 */
	public static String getPostRequestStr(String string){
		String str = string;
		try {
			if(!isBlank(string)){
				String sss = new String(string.getBytes("UTF-8"), "UTF-8");//ISO-8859-1
				str = URLDecoder.decode(sss, "UTF-8") ;
			}
		} catch (Exception e) {
			//UnsupportedEncodingException
			System.out.println("编码转换出错");
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * 去掉字符串中的换行符
	 * 
	 */
	public static String replaceStringLineRN(String string){
		String str = string;
		try {
			if(!isBlank(string)){
				str = string.replaceAll(System.getProperty("line.separator"), "");
			}
		} catch (Exception e) {
			System.out.println("字符串去掉换行符出错!");
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * 用字符串中的换行符分隔字符串，一行为一条记录，添加到List中
	 * 
	 */
	public static List<String> getStringArrayByStringLine(String string){
		List<String> list = null;
		try {
			if(!isBlank(string)){
				list = new ArrayList<String>();
				String[] str_array = string.split(System.getProperty("line.separator"));
				for(int i=0; i<str_array.length; i++){
					list.add(str_array[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("分隔字符串，一行为一条记录，添加到List中出错!");
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Object对象转换为字符串，如果对象为空，则返回空串，否则返回该对象转换的字符串
	 * 
	 */
	public static String getObjectToString(Object object){
		String str = "";
		try {
			if(object != null){
				str = object.toString();
			}
		} catch (Exception e) {
			System.out.println("Object转换为字符串出错!");
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * 对象转为Integer对象，如果对象为空，则转为空对象，否则返回该对象转为Boolean对象
	 * 
	 */
	public static Boolean getObjectToBoolean(Object object){
		Boolean bool = null;
		try {			
			if(object != null && !isBlank(object.toString())){
				String str = getObjectToString(object);
				if(str.equalsIgnoreCase("TRUE")){
					bool = true;
				}else{
					bool = false;
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("字符串TRUE、FALSE转为Boolean格式出错!");
		}
		return bool;
	}
	
	/**
	 * 对象转为Long对象，如果对象为空，则转为空对象，否则返回该对象转为Long数字格式
	 * 
	 */
	public static Long getObjectToLong(Object object){
		Long num = null;
		try {			
			if(object != null && !isBlank(object.toString())){
				num = Long.valueOf(object.toString());
			}
		} catch (NumberFormatException e) {
			System.out.println("字符串转为Long数字格式出错!");
			e.printStackTrace();
		}
		return num;
	}
	
	/**
	 * 对象转为Integer对象，如果对象为空，则转为空对象，否则返回该 对象转为Integer数字格式的对象
	 * 
	 */
	public static Integer getObjectToInteger(Object object){
		Integer num = null;
		try {			
			if(object != null && !isBlank(object.toString())){
				num = new Integer(object.toString());
			}
		} catch (NumberFormatException e) {
			System.out.println("字符串转为Integer数字格式出错!");
		}
		return num;
	}
	
	/**
	 * 对象转为Float对象，如果对象为空，则转为空对象，否则返回该对象转为Float数字格式的对象
	 * 
	 */
	public static Float getObjectToFloat(Object object){
		Float f = null;
		try {			
			if(object != null && !isBlank(object.toString())){
				f = new Float(getObjectToString(object));
			}
		} catch (NumberFormatException e) {
			System.out.println("字符串转为Float数字格式出错!");
		}
		return f;
	}
	/**
	 * 对象转为Double对象，如果对象为空，则转为空对象，否则返回该对象转为Double数字格式的对象
	 * 
	 */
	public static Double getObjectToDouble(Object object){
		Double d = null;
		try {			
			if(object != null && !isBlank(object.toString())){
				d = new Double(object.toString());
			}
		} catch (NumberFormatException e) {
			System.out.println("字符串转为Double数字格式出错!");
		}
		return d;
	}
	
	
	/**
	 * Boolean类型的对象转换为字符串，如果对象为空，则返回空串，否则返回该对象转换的字符串
	 * 
	 */
	public static String getBooleanToString(Boolean bool){
		String str = "";
		try {
			if(bool != null){
				str = bool.toString();
			}			
		} catch (Exception e) {
			System.out.println("Boolean对象转为字符串出错!");
		}
		return str;
	}
	
	/**
	 * Long类型的对象转换为字符串，如果对象为空，则返回空串，否则返回该对象转换的字符串
	 * 
	 */
	public static String getLongToString(Long n){
		String str = "";
		try {
			if(n != null){
				str = String.valueOf(n);
			}
		} catch (Exception e) {
			System.out.println("Long转换为字符串出错!");
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * Integer类型的对象转换为字符串，如果对象为空，则返回空串，否则返回该对象转换的字符串
	 * 
	 */
	public static String getIntegerToString(Integer n){
		String str = "";
		try {
			if(n != null){
				str = String.valueOf(n);
			}
		} catch (Exception e) {
			System.out.println("Integer转换为字符串出错!");
		}
		return str;
	}
	
	/**
	 * Float类型的对象转换为字符串，如果对象为空，则返回空串，否则返回该对象转换的字符串
	 * 
	 */
	public static String getFloatToString(Float num){
		String str = "";
		try {
			if(num != null){
				str = String.valueOf(num);
			}
		} catch (Exception e) {
			System.out.println("Float对象转换为字符串出错!");
		}
		return str;
	}
	
	/**
	 * 传入一个Double类型，转换为字符串，如果Double对象为空，则为空串
	 * 
	 */
	public static String getDoubleToString(Double num){
		String str = "";
		try {
			if(num != null){
				str = String.valueOf(num);
			}
		} catch (Exception e) {
			System.out.println("Double对象转换为字符串出错!");
		}
		return str;
	}
	
	
	
	/**
	 * int类型的对象转换为字符串，如果对象为空，则返回空串，否则返回该对象转换的字符串
	 * 
	 */
	public static String getIntToString(int n){
		String str = "";
		try {
			Integer num = new Integer(n);
			str = getIntegerToString(num);
		} catch (Exception e) {
			System.out.println("int类型数字转为字符串出错!");
		}
		return str;
	}

	/**
	 * 字符串转为int对象，如果字符串为空，则返回0，否则返回该字符串转int数字格式
	 * 
	 */
	public static int getStringToInt(String string){
		int num = 0;
		try {			
			if(!isBlank(string)){
				num = Integer.parseInt(string);
			}
		} catch (NumberFormatException e) {
			System.out.println("字符串转为int类型数字格式出错!");
		}
		return num;
	}
	
	/**
	 * long类型的对象转换为字符串，如果对象为空，则返回空串，否则返回该对象转换的字符串
	 * 
	 */
	public static String getlongToString(long n){
		String str = "";
		try {
			Long num = new Long(n);
			str = getLongToString(num);
		} catch (Exception e) {
			System.out.println("long类型数字转为字符串出错!");
		}
		return str;
	}

	/**
	 * 字符串转为long对象，如果字符串为空，则返回0，否则返回该字符串转int数字格式
	 * 
	 */
	public static long getStringTolong(String string){
		long num = 0;
		try {			
			if(!isBlank(string)){
				num = Long.parseLong(string);
			}
		} catch (NumberFormatException e) {
			System.out.println("字符串转为long类型数字格式出错!");
		}
		return num;
	}
	
	/**
	 * 字符串转为long对象，如果字符串为空，则返回0，否则返回该字符串转int数字格式
	 * 
	 */
	public static Double getStringToDouble(String string){
		Double d = 0.0d;
		try {			
			if(!isBlank(string)){
				d = Double.parseDouble(string);
			}
		} catch (NumberFormatException e) {
			System.out.println("字符串转为Double类型数字格式出错!");
		}
		return d;
	}
	
	/**
	 * Byte对象类型的值，转为String字符串类型，如果Byte对象为空，则为空串
	 * 
	 */
	public static String getByteToString(Byte b){
		String str = "";
		try {
			if(b != null){
				str = String.valueOf(b);
			}
		} catch (Exception e) {
			System.out.println("Byte转换为字符串的时候出错!");
		}
		return str;
	}
	
	/**
	 * Oracle的Blob字段类型的值转为byte[]类型的值，如果bolb为空，则返回空对象
	 * 
	 */
	public static byte[] getBlobToByte(Blob blob){
		byte[] b = null;
		try {
			if(blob != null){
				b = blob.getBytes(1, (int) blob.length());
			}
		} catch (Exception e) {
			System.out.println("Oracle的Blob类型转为byte[]类型出错!");
			e.printStackTrace();
		}
		return b;
	}
	
	/**
	 * 字符串类型的值，转为byte[]类型的值，如果字符串为空或空串，刚返回null
	 * 
	 */
	public static byte[] getStringToByte(String string){
		byte[] b = null;
		try {
			if(!isBlank(string)){
				b = string.getBytes();
			}
		} catch (Exception e) {
			System.out.println("运行StrToBlob时出错!");
			e.printStackTrace();
		}
		return b;
	}
	
	/**
	 * 截取字符串最后一位
	 * 
	 */
	public static String subStringLastWord(String string){
		String str = string;
		try {
			if(!isBlank(string)){
				str = string.substring(0, string.length()-1);
			}
		} catch (Exception e) {
			System.out.println("截到字符串最后一位出错!");
		}
		return str;
	}
	
	/**
	 * 文件名转编码
	 * 
	 */
	public static String getFileNameByURLCode(String filename){
		String fn = filename;
		try {
			fn = URLEncoder.encode(filename,"UTF-8");
			if(fn.length() > 150){
				fn = new String(filename.getBytes("GBK"),"ISO-8859-1");
			}
		} catch (Exception e) {
			System.out.println("文件名转编码出错!");
			e.printStackTrace();
		}
		return fn;
	}
	
	/**
	 * 修补15位居民身份证号码为18位
	 * @param personIDCode 身份证
	 * @return 转换后的身份证
	 * 
	 */
	public static String fixPersonIDCode15To18(String personIDCode) {
		String retIDCode = "";
		if (personIDCode == null || personIDCode.trim().length() != 15) {
			retIDCode = personIDCode;
		}
		else{
			String id17 = personIDCode.substring(0, 6) + "19" + personIDCode.substring(6, 15); // 15位身份证补'19'

			char[] code = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' }; // 11个
			int[] factor = { 0, 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4, 8, 5, 10, 9, 7 }; // 18个;
			int[] idcd = new int[18];
			int i;
			int j;
			int sum;
			int remainder;

			for (i = 1; i < 18; i++) {
				j = 17 - i;
				idcd[i] = Integer.parseInt(id17.substring(j, j + 1));
			}

			sum = 0;
			for (i = 1; i < 18; i++) {
				sum = sum + idcd[i] * factor[i];
			}
			remainder = sum % 11;
			String lastCheckBit = String.valueOf(code[remainder]);
			retIDCode = id17 + lastCheckBit;
		}
		return retIDCode;
	}
	
	/**
	 * 18位身份证号码转换为15位居民身份证号码
	 * @param personIDCode 身份证
	 * @return 转换后的身份证
	 * 
	 */
	public static String fixPersonIDCode18To15(String personIDCode) {
		String retIDCode = "";
		if (personIDCode == null || personIDCode.trim().length() != 18) {
			retIDCode = personIDCode;
		}
		else{
			retIDCode = personIDCode.substring(0, 6) + personIDCode.substring(8, 17);
		}
		return retIDCode;
	}
	
	/**
	 * 获得32位的UUID
	 * 
	 */
	public static String getUUIDString() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		return uuid;
	}
	
	/**
	 * 去除字符串中的空格、回车、换行符、制表符
	 * 
	 */
	public static String getRemoveErrStr(String xml){
		String str = "";
		try {
			//Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Pattern p = Pattern.compile("\t|\r|\n");//不去字符串中的空格
			Matcher m = p.matcher(xml);
			str = m.replaceAll("");
			/**
			 * 笨方法：String s = "你要去除的字符串";
            1.去除空格：s = s.replace('\\s','');
            2.去除回车：s = s.replace('\n','');
				这样也可以把空格和回车去掉，其他也可以照这样做。
			注：\n 回车(\u000a)
 				\t 水平制表符(\u0009)
 				\s 空格(\u0008)
 				\r 换行(\u000d)*/
		} catch (Exception e) {
			System.out.println("去除字符串中的空格、回车、换行符、制表符出错!");
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 把特殊符号的字符串转换为空格
	 * 
	 */
	public static String getReplaceString(String string){
		String str = "";
		try {
			string = string.replace("\'", " ");
			string = string.replace("'", " ");
			str = string;
		} catch (Exception e) {
			System.out.println("把特殊符号的字符串转换为空格出错!");
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 格式化字符串中的HTML特殊符号
	 *
	 */
	public static String getHtmlEscapeStr(String string){
		String str = "";
		try {
			str = HtmlUtils.htmlEscape(string);
		} catch (Exception e) {
			System.out.println("格式化字符串中的HTML特殊符号出错!");
			e.printStackTrace();
		}
		return str;
	}
}
