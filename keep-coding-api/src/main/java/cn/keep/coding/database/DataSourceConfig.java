package cn.keep.coding.database;

import cn.keep.coding.database.impl.DaoSupportImpl;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by kingapex on 2018/3/6.
 * 数据源配置
 * @author kingapex
 * @version 1.0
 * @since 7.0.0
 * 2018/3/6
 */
@Configuration
@ConditionalOnProperty(value = "keepcoding.product", havingValue = "stand")
public class DataSourceConfig {

    /*----------------------------------------------------------------------------*/
    /*                           DaoSupport配置                                    */
    /*----------------------------------------------------------------------------*/

    /**
     * 商品daoSupport
     * @param jdbcTemplate 商品jdbcTemplate
     * @return
     */
    @Bean(name = "testDaoSupport")
    @Primary
    public DaoSupport testsDaoSupport(@Qualifier("testJdbcTemplate") JdbcTemplate jdbcTemplate) {
        DaoSupport daosupport = new DaoSupportImpl(jdbcTemplate);
        return daosupport;
    }

    /**
     * 交易daoSupport
     * @param jdbcTemplate 交易jdbcTemplate
     * @return
     */
    @Bean(name = "devDaoSupport")
    public DaoSupport tradeDaoSupport(@Qualifier("devJdbcTemplate") JdbcTemplate jdbcTemplate) {
        DaoSupport daosupport = new DaoSupportImpl(jdbcTemplate);
        return daosupport;
    }


    /*----------------------------------------------------------------------------*/
    /*                           JdbcTemplate 配置                                */
    /*----------------------------------------------------------------------------*/

    /**
     * 商品jdbcTemplate
     * @param dataSource 商品数据源
     * @return
     */
    @Bean(name = "testJdbcTemplate")
    @Primary
    public JdbcTemplate testJdbcTemplate(
            @Qualifier("testDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


    /**
     * 交易jdbcTemplate
     * @param dataSource 交易数据源
     * @return
     */
    @Bean(name = "devJdbcTemplate")
    public JdbcTemplate devJdbcTemplate(
            @Qualifier("devDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }





    /*----------------------------------------------------------------------------*/
    /*                           数据源配置                                        */
    /*----------------------------------------------------------------------------*/


    /**
     * test数据源
     * @return
     */
    @Bean(name = "testDataSource")
    @Qualifier("testDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.druid.test")
    public DataSource testDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * dev数据源
     * @return
     */
    @Bean(name = "devDataSource")
    @Qualifier("devDataSource")
    @ConfigurationProperties(prefix="spring.datasource.druid.dev")
    public DataSource devDataSource() {
        return  DruidDataSourceBuilder.create().build();
    }



    /*----------------------------------------------------------------------------*/
    /*                           事务配置                                         */
    /*----------------------------------------------------------------------------*/

    /**
     * 会员事务
     * @param dataSource
     * @return
     */
    @Bean
    @Primary
    public PlatformTransactionManager memberTransactionManager(@Qualifier("testDataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 商品事务
     * @param dataSource
     * @return
     */
    @Bean

    public PlatformTransactionManager devTransactionManager(@Qualifier("devDataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
