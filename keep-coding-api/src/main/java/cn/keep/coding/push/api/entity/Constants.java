package cn.keep.coding.push.api.entity;

/**
 * 系统常量
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 *
 */
public class Constants {
	
	// SESSION中的登录用户对象
	public final static String SESSION_LOGON_USER 					= "_SESSION_LOGON_USER";	
	// API字符集
	public final static String API_CHARSET 							= "UTF-8";

	//邮件发送地址
	public final static String FROM_MAIL					= "gnw@txtws.com";
	public final static String FROM_MAIL_PWD				= "Lwtx0711";

	//傲众云短信
	public final static String SMS_UID						= "20641";
	public final static String SMS_UID_PWD					= "qgjy123456";

	public final static String SMS_SOURCE_01					= "01";		//傲众云短信
	public final static String SMS_SOURCE_99					= "99";		//阿里云短信

	//极光推送
	public final static String MASTER_SECRET 				= "fc1d533126ec7ca07acf425c";
	public final static String APP_KEY 						= "23e3c1dd1c86c468158fd565";

	//vivo推送
	public final static String VIVO_APP_ID 					= "10282";
	public final static String VIVO_APP_KEY 				= "6fb25c25-4aa5-458c-a8ac-4ac03de1b100";
	public final static String VIVO_APP_SECRET 				= "ef3c3aa4-8814-4f2b-8c7f-06253a99e38a";

	//华为推送
	public final static String HUAWEI_APP_ID				= "100467925";
	public final static String HUAWEI_APP_SECRET			= "22250ca41dde9a76ffc1c99379375ec1";

	public final static String RMQ_GNW_PUSH_EXCHANGE 					= "gnw_push_mq_exchange";					// 推送服务交换器
	public final static String RMQ_GNW_PUSH_SMS_QUEUE 					= "gnw_push_sms_queue";						// 短信推送队列
	public final static String RMQ_GNW_PUSH_ALIYUN_SMS_QUEUE 			= "gnw_push_aliyun_sms_queue";				// 短信推送队列(阿里云)
	public final static String RMQ_GNW_PUSH_ALIYUN_SMS_QUEUE_ERROR		= "gnw_push_aliyun_sms_queue_error";		// 短信推送错误队列(阿里云)
	public final static String RMQ_GNW_PUSH_MAIL_QUEUE 					= "gnw_push_mail_queue";					// 邮件推送队列
	public final static String RMQ_GNW_PUSH_JIGUANG_QUEUE 				= "gnw_push_jiguang_queue";					// 极光推送队列
 	public final static String RMQ_GNW_PUSH_VIVO_SEND_QUEUE 			= "gnw_push_vivo_send_queue";				// vivo推送队列
	public final static String RMQ_GNW_PUSH_VIVO_SEND_GROUP_QUEUE 		= "gnw_push_vivo_send_group_queue";			// vivo推送(群推)队列
	public final static String RMQ_GNW_PUSH_HUAWEI_SEND_QUEUE 			= "gnw_push_huawei_send_queue";				// 华为推送队列
	public final static String RMQ_GNW_PUSH_MI_SEND_QUEUE 				= "gnw_push_mi_send_queue";					// 小米推送队列


	public final static String PLATFORM_PC		= "01";						//PC
	public final static String PLATFORM_IOS 	= "02";						//ios
	public final static String PLATFORM_ANDROID = "03";						//安卓

	public final static String GNW_PUSH_REDIS ="gnw-push";	//redis 缓存

	//redis缓存
	public final static String REDIS_SMS_SOURCE		= "sms_source";			//短信配置项目来源
	public final static String REDIS_MAIL_SOURCE	= "mail_source";		//邮件配置项目来源
    public final static String REDIS_JG_SOURCE	    = "jigunag_source";		//邮件配置项目来源

	public final static String REDIS_SMS_CONFIG			= "sms_config";			//短信配置缓存key
	public final static String REDIS_MAIL_CONFIG		= "mail_config";		//邮件配置缓存key
    public final static String REDIS_JG_CONFIG	    	= "jigunag_config";	//极光配置缓存key
	public final static String REDIS_VIVO_CONFIG	    = "vivo_config";		//vivo配置缓存key
	public final static String REDIS_HUAWEI_CONFIG	    = "huawei_config";		//华为配置缓存key
	public final static String REDIS_MI_CONFIG	    	= "mi_config";			//小米配置缓存key

	public final static String REDIS_HUAWEI_AUTH_TOKEN  	= "huawei_auth_token";	//华为鉴权token缓存key
	public final static String REDIS_VIVO_AUTH_TOKEN  		= "vivo_auth_token";	//vivo鉴权token缓存key

	public final static String REDIS_SMS_SEND_PHONE ="sms_send_phone";	//短信已发送手机

	//推送方式
	public final static String PUSH_TYPE_MAIL 					= "mail";							// 邮件推送
	public final static String PUSH_TYPE_SMS 					= "sms";							// 短信推送
	public final static String PUSH_TYPE_JIGUANG 				= "jiguang";						// 极光推送
	public final static String PUSH_TYPE_VIVO_SEND 				= "vivo_send";						// vivo推送
	public final static String PUSH_TYPE_VIVO_SEND_GROUP		= "vivo_send_group";				// vivo推送
	public final static String PUSH_TYPE_HUAWEI_SEND			= "huawei_send";					// 华为推送
	public final static String PUSH_TYPE_HUAWEI					= "huawei";							// 华为推送
	public final static String PUSH_TYPE_MI_SEND				= "mi_send";						// 小米推送

	//聚合推送类型
	public final static String PA_TYPE_JIGUANG			="001";	//极光
	public final static String PA_TYPE_HUAWEI			="002";	//华为
	public final static String PA_TYPE_VIVO				="003";	//vivo
	public final static String PA_TYPE_MI				="004";	//小米

	//推送类型（后台管理）
	public final static String PT_TYPE_SMS				="pt_01";	//短信
	public final static String PT_TYPE_MAIL				="pt_02";	//邮件
	public final static String PT_TYPE_JIGUANG			="pt_03";	//极光
	public final static String PT_TYPE_HUAWEI			="pt_04";	//华为
	public final static String PT_TYPE_VIVO				="pt_05";	//vivo
	public final static String PT_TYPE_MI				="pt_06";	//小米

	//IOS
	public final static String RMQ_GNW_PUSH_IOSMDM_EXCHANGE = "gnw_push_iosmdm_exchange";					// 推送服务交换器
	public final static String RMQ_GNW_PUSH_IOSMDM_QUEUE = "gnw_push_iosmdm_queue";
}
