package cn.keep.coding.base.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用工具类(单例)
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 */
public class CommonUtil {
	
	private final int COM_SUCCESS_STATUS = 0;
	private final int COM_FAILURE_STATUS = -1;
	
	private CommonUtil() {}
	
	private static class CommonUtilManageHolder {
		private static CommonUtil instance = new CommonUtil();
	}
	
	public static CommonUtil getInstance() {
		return CommonUtilManageHolder.instance;
	}
	
	/**
	 * 验证参数是否为空
	 * @param args 参数对象
	 * @param argSymbols 参数符号数组
	 * @return
	 */
	public JSONObject verifyArgsEmpty(JSONObject args, String[] argSymbols) {
		JSONObject result = new JSONObject();
		String argSymbol = null;
		for (int i = 0; i < argSymbols.length; i++) {
			argSymbol = argSymbols[i];
			if(StringUtil.isBlank(args.getString(argSymbol))) {
				result.put("status", COM_FAILURE_STATUS);
				result.put("message", argSymbol + " miss!");
				return result;
			}
		}
		result.put("status", COM_SUCCESS_STATUS);
		result.put("message", "ok");
		return result;
	}
	
	/**
	 * 验证参数是否为空
	 * @param argsStr 参数字符串
	 * @param argSymbols 参数符号数组
	 * @return
	 */
	public JSONObject verifyArgsEmpty(String argsStr, String[] argSymbols) {
		JSONObject result = new JSONObject();
		String argSymbol = null;
		JSONObject args = JSONObject.parseObject(argsStr);
		for (int i = 0; i < argSymbols.length; i++) {
			argSymbol = argSymbols[i];
			if(StringUtil.isBlank(args.getString(argSymbol))) {
				result.put("status", COM_FAILURE_STATUS);
				result.put("message", argSymbol + " miss!");
				return result;
			}
		}
		result.put("status", COM_SUCCESS_STATUS);
		result.put("message", "ok");
		return result;
	}

	/**
	 * 获取客户端IP
	 * @param request
	 * @return
	 */
	public String getClientIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if(!StringUtil.isBlank(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			int index = ip.indexOf(",");
			if(index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if(!StringUtil.isBlank(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}

}
