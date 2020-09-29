package cn.keep.coding.push.provider.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Redis 配置类
 * @author: shemg
 * @mail xuys@txtws.com
 * @date: 2018-07-05 14:19
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {

    private String host;
    private int port;
    private String password;
    private int timeout;
    private int database;

    @Bean(name = "jedisPoolConfig")
    @ConfigurationProperties(prefix = "spring.redis.pool")
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestOnReturn(true);
        return jedisPoolConfig;
    }

    /**
     * 配置shardedJedisPool
     * @return
     */
    @Bean(name = "shardedJedisPool")
    public ShardedJedisPool shardedJedisPool(@Qualifier(value = "jedisPoolConfig") JedisPoolConfig poolConfig) {
        JedisShardInfo writeJedisShardInfo = new JedisShardInfo(this.host, this.port);
        writeJedisShardInfo.setPassword(this.password);
        List<JedisShardInfo> jiList = new ArrayList<JedisShardInfo>();
        jiList.add(writeJedisShardInfo);
        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(poolConfig, jiList);
        return shardedJedisPool;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }
}
