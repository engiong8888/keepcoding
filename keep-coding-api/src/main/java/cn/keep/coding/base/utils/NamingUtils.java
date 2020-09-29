package cn.keep.coding.base.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 命名格式工具
 * 
 * @author shemg
 * @date 2015-08-26
 *
 */
public class NamingUtils {
	
	/**
	 * 将驼峰式命名的字符串转换为下划线小写方式。如果转换前的驼峰式命名的字符串为空，则返回空字符串。</br>
	 * 例如：HelloWorld->hello_world
	 * @param name 转换前的驼峰式命名的字符串
	 * @return 转换后下划线小写方式命名的字符串
	 */
	public static String underscoreNameLC(String name) {
	    return underscoreNameUC(name).toLowerCase();
	}
	
	/**
	 * 将驼峰式命名的字符串转换为下划线大写方式。如果转换前的驼峰式命名的字符串为空，则返回空字符串。</br>
	 * 例如：HelloWorld->HELLO_WORLD
	 * @param name 转换前的驼峰式命名的字符串
	 * @return 转换后下划线大写方式命名的字符串
	 */
	public static String underscoreNameUC(String name) {
	    StringBuilder result = new StringBuilder();
	    if (name != null && name.length() > 0) {
	        // 将第一个字符处理成大写
	        result.append(name.substring(0, 1).toUpperCase());
	        // 循环处理其余字符
	        for (int i = 1; i < name.length(); i++) {
	            String s = name.substring(i, i + 1);
	            // 在大写字母前添加下划线(s >= 65 && s<=90) || ( s >= 97 && s <= 122)
	            if (isLetter(s.charAt(0)) && s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
	                result.append("_");
	            }
	            // 其他字符直接转成大写
	            result.append(s.toUpperCase());
	        }
	    }
	    return result.toString();
	}
	 
	/**
	 * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。</br>
	 * 例如：HELLO_WORLD->HelloWorld
	 * @param name 转换前的下划线大写方式命名的字符串
	 * @return 转换后的驼峰式命名的字符串
	 */
	public static String camelName(String name) {
	    StringBuilder result = new StringBuilder();
	    // 快速检查
	    if (name == null || name.isEmpty()) {
	        // 没必要转换
	        return "";
	    } else if (!name.contains("_")) {
	        // 不含下划线，仅将首字母小写
	        return name.substring(0, 1).toLowerCase() + name.substring(1);
	    }
	    // 用下划线将原始字符串分割
	    String camels[] = name.split("_");
	    for (String camel :  camels) {
	        // 跳过原始字符串中开头、结尾的下换线或双重下划线
	        if (camel.isEmpty()) {
	            continue;
	        }
	        // 处理真正的驼峰片段
	        if (result.length() == 0) {
	            // 第一个驼峰片段，全部字母都小写
	            result.append(camel.toLowerCase());
	        } else {
	            // 其他的驼峰片段，首字母大写
	            result.append(camel.substring(0, 1).toUpperCase());
	            result.append(camel.substring(1).toLowerCase());
	        }
	    }
	    return result.toString();
	}
	
	/**
	 * 判断是否为字母
	 * @return
	 */
	private static boolean isLetter(char c) {
		int i = (int) c;
		if (( i >= 65 && i <= 90) || ( i >= 97 && i <= 122)) {   
			return true;
		}
		else {   
			return false;
		}
	}
	
	/**
	 * JSON字符串将键名的驼峰式命名转换为下划线小写方式
	 * @return
	 */
	public static String underscoreNameLCForJsonKey(String jsonStr) {
		StringBuilder sbd = new StringBuilder();
		String regex = "\"(.*?)\":\"(.*?)\"";
		Matcher matcher = Pattern.compile(regex).matcher(jsonStr);
		int lastEnd = 0; 
		while(matcher.find()) {
			String ret = matcher.group(1);
			sbd.append(jsonStr.substring(lastEnd, matcher.start() + 1));
			sbd.append(underscoreNameLC(ret));
			sbd.append(jsonStr.substring(matcher.start() + ret.length() + 1, matcher.end()));
			lastEnd = matcher.end();
		}
		if (lastEnd != 0) {
			sbd.append(jsonStr.substring(lastEnd));
		}
		return sbd.toString();
	}
	
	/*public static void main(String[] args) {
		String jsonstr = "{\"myInfo\":[{\"id\":\"SLMT_1439545343\", \"startTime\":\"4544454\", \"endTime\":\"4tdEm544454\"}]}";
		
		String result = underscoreNameLCForJsonKey(jsonstr);
		System.out.println("before******");
		System.out.println(jsonstr);
		System.out.println("result*****");
		System.out.println(result);
	}*/
}
