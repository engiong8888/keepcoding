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
 * @author: shemg
 * @mail xuys@txtws.com
 * @date: 2018-07-05 17:05
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
