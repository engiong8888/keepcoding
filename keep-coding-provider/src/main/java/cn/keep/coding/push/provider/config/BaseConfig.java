package cn.keep.coding.push.provider.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 基础配置类
 * @author: chengzd
 * @mail chengzd@txtws.com
 * @date: 2018-11-15 15:26
 */
@Component
@ConfigurationProperties(prefix = "baseConfig")
public class BaseConfig {

    private String apiAccessDomain;

    public String getApiAccessDomain() {
        return apiAccessDomain;
    }

    public void setApiAccessDomain(String apiAccessDomain) {
        this.apiAccessDomain = apiAccessDomain;
    }
}
