package cn.keep.coding.base.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 基础配置实体类
 * author: shemg
 * date: 2018-06-19 14:33
 */
public class BaseConfig {
    String logPath = null;

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }
}
