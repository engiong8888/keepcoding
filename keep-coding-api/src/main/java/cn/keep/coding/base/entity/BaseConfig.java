package cn.keep.coding.base.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 基础配置实体类
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
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
