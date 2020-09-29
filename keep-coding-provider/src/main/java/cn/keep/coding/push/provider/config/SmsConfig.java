package cn.keep.coding.push.provider.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 短信配置类
 *
 * @author: chengzd
 * @mail chengzd@txtws.com
 * @date: 2018-11-02 14:24
 */
@Component
@ConfigurationProperties(prefix = "sms")
public class SmsConfig {

    private int timeOut;
    private String frequency;
    private String source;

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
