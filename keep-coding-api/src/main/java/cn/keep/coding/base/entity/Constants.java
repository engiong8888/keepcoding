package cn.keep.coding.base.entity;

/**
 * 系统常量
 * @author shemg
 * @date 2018/07/05
 *
 */
public class Constants {

	// SESSION中的登录用户对象
	public final static String SESSION_LOGON_USER 					= "_SESSION_LOGON_USER";
	// API字符集
	public final static String API_CHARSET 							= "UTF-8";
	// 平台标识
	public final static String PLATFORM_WEB_H5 						= "H5";									// H5页面

	public final static String PLATFORM_WECHAT_DEFAULT 			= "green_box";									// 默认微信平台

	// 支付方式
	public final static String PAY_TYPE_WECHATPAY 					= "wechatpay";							// 微信支付
	public final static String PAY_TYPE_ALIPAY 						= "alipay";							// 支付宝支付
	public final static String PAY_TYPE_UNIONPAY 					= "unionpay";							// 银联支付

	// 微信支付交易类型
	public final static String WECHAT_PAY_TRADE_TYPE_JSAPI 		= "JSAPI";								// 公众号支付
	public final static String WECHAT_PAY_TRADE_TYPE_NATIVE 		= "NATIVE";							// 原生扫码支付
	public final static String WECHAT_PAY_TRADE_TYPE_APP 			= "APP";								// app支付

	// 微信支付交易结果
	public final static String WECHAT_PAY_RESULT_CODE_SUCCESS 		= "SUCCESS";							// 交易成功
	public final static String WECHAT_PAY_RESULT_CODE_FAIL 		= "FAIL";								// 交易失败

	// 微信支付交易状态
	public final static String WECHAT_PAY_TRADE_TYPE_SUCCESS 		= "SUCCESS";							// 支付成功
	public final static String WECHAT_PAY_TRADE_TYPE_REFUND 		= "REFUND";							// 转入退款
	public final static String WECHAT_PAY_TRADE_TYPE_NOTPAY 		= "NOTPAY";							// 未支付
	public final static String WECHAT_PAY_TRADE_TYPE_CLOSED 		= "CLOSED";							// 已关闭
	public final static String WECHAT_PAY_TRADE_TYPE_REVOKED 		= "REVOKED";							// 已撤销（刷卡支付）
	public final static String WECHAT_PAY_TRADE_TYPE_USERPAYING 	= "USERPAYING";						// 用户支付中
	public final static String WECHAT_PAY_TRADE_TYPE_PAYERROR 		= "PAYERROR";							// 支付失败(其他原因，如银行返回失败)

	// 支付宝支付交易状态
	public final static String ALIPAY_PAY_WAIT_BUYER_PAY 		= "WAIT_BUYER_PAY";						// 交易创建，等待买家付款
	public final static String ALIPAY_PAY_TRADE_CLOSED 		= "TRADE_CLOSED";							// 未付款交易超时关闭，或支付完成后全额退款
	public final static String ALIPAY_PAY_TRADE_SUCCESS 		= "TRADE_SUCCESS";							// 交易支付成功
	public final static String ALIPAY_TRADE_FINISHED 			= "TRADE_FINISHED";						// 交易结束，不可退款

	// REDIS缓存
	public final static String REDIS_WECHAT_ACCESS_TOKEN 			= "wechat_access_token";				// 微信AccessToken访问凭据
	public final static String REDIS_WECHAT_JSAPI_TICKET 			= "wechat_jsapi_ticket";				// 微信jsapi_ticket访问凭据
	public final static String REDIS_WECHAT_JSAPI_SIGN_INFO 		= "wechat_jsapi_sign_info";			// 微信jsapi签名信息
	public final static String REDIS_WECHAT_USER_INTERACT 			= "wechat_user_interact";				// 用户交互列表
	public final static String REDIS_ORDER_CODE_COUNT				= "order_code_count";					// 订单号计数器


	public final static String ORDER_BUSINESS_CODE_GREENBOX		= "GB";									// 订单业务编码-格雷盒子
	public final static String ORDER_BUSINESS_CODE_ZHIXIKE			= "ZXK";								// 订单业务编码-智习客
	public final static String ORDER_BUSINESS_CODE_PAY				= "PAY";								// 订单业务编码-支付服务
	public final static String ORDER_BUSINESS_CODE_PAY_REDPACK	= "PAYWRP";							// 订单业务编码-支付服务微信红包

}
