package cn.keep.coding.base.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;


/**
 * 邮件类
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 *
 */
public class MailUtil {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private String smtpHost = null;
	private String fromMail = null;
	private String fromMailPwd = null;

	public MailUtil(String smtpHost, String fromMail, String fromMailPwd) {
		this.smtpHost = smtpHost;
		this.fromMail = fromMail;
		this.fromMailPwd = fromMailPwd;
	}

	public MailUtil(String fromMail, String fromMailPwd) {
		this.smtpHost = "smtp.exmail.qq.com";
		this.fromMail = fromMail;
		this.fromMailPwd = fromMailPwd;
	}

	public void sendMessage(String to, String subject, String messageText) throws MessagingException, UnsupportedEncodingException {
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");						// 指定是否需要SMTP验证
		props.setProperty("mail.smtp.host", this.smtpHost);				// 指定SMTP服务器
		props.put("mail.transport.protocol", "smtp");
		Session mailSession = Session.getDefaultInstance(props);
		//mailSession.setDebug(true);										// 是否在控制台显示debug信息
		InternetAddress fromAddress = new InternetAddress(this.fromMail);
		InternetAddress toAddress = new InternetAddress(to);
		MimeMessage testMessage = new MimeMessage(mailSession);
		testMessage.setFrom(fromAddress);
		testMessage.addRecipient(RecipientType.TO, toAddress);
		testMessage.setSentDate(new Date());
		testMessage.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
		testMessage.setContent(messageText, "text/html;charset=utf8");
		Transport transport = mailSession.getTransport("smtp");
		transport.connect(this.smtpHost, this.fromMail, this.fromMailPwd);
		transport.sendMessage(testMessage, testMessage.getAllRecipients());
		transport.close();
	}

	public JSONObject toSendMail(String to, String subject, String messageText){
		JSONObject result = new JSONObject();
		MailUtil mu = new MailUtil(this.fromMail, this.fromMailPwd);
		try {
			mu.sendMessage(to, subject, messageText);
			result.put("status", 0);
			result.put("message", "success");
		} catch (MessagingException e) {
			result.put("status", -1);
			result.put("message",e.getMessage());
		} catch (UnsupportedEncodingException e) {
			result.put("status", -1);
			result.put("message",e.getMessage());
		}
		return result;
	}

	/*public static void main(String[] args) {
		String to = "chengzd@txtws.com";
		String subject = "账户余额不足";
		String messageText = "账户余额不足";
		MailUtil mu = new MailUtil("gnw@txtws.com", "Lwtx0711");
		try {
			mu.sendMessage(to, subject, messageText);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}*/

}
