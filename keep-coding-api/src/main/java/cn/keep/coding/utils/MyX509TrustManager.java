package cn.keep.coding.utils;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
/**
 * 证书信任管理器（用于https请求）
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 */
public class MyX509TrustManager implements X509TrustManager {

	public void checkClientTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	public void checkServerTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}

}
