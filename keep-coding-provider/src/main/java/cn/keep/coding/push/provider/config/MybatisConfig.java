package cn.keep.coding.push.provider.config;

import cn.keep.coding.base.db.SimpleMybatisDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Mybatis 配置类
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 */
//@Configuration
public class MybatisConfig {

//    @Bean(name = "dataSource")
//    @Qualifier(value = "dataSource")
////    @Primary
//    @ConfigurationProperties(prefix = "c3p0")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
//    }
//
//    @Bean(name = "simpleMybatisDao")
//    public SimpleMybatisDao simpleMybatisDao(@Qualifier(value = "sqlSessionTemplate") SqlSessionTemplate sqlSessionTemplate) {
//        SimpleMybatisDao simpleMybatisDao = new SimpleMybatisDao();
//        simpleMybatisDao.setSqlSessionTemplate(sqlSessionTemplate);
//        return simpleMybatisDao;
//    }
}
