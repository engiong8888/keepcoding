package cn.keep.coding.push.provider.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 基础配置类
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
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
