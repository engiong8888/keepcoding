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
 * 数据源配置
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
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

    /**
     * 本地daoSupport
     * @param jdbcTemplate 本地jdbcTemplate
     * @return
     */
    @Bean(name = "localDaoSupport")
    public DaoSupport localDaoSupport(@Qualifier("localJdbcTemplate") JdbcTemplate jdbcTemplate) {
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


    /**
     * 本地jdbcTemplate
     * @param dataSource 交易数据源
     * @return
     */
    @Bean(name = "localJdbcTemplate")
    public JdbcTemplate localJdbcTemplate(
            @Qualifier("localDataSource") DataSource dataSource) {
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

    /**
     * local数据源
     * @return
     */
    @Bean(name = "localDataSource")
    @Qualifier("localDataSource")
    @ConfigurationProperties(prefix="spring.datasource.druid.local")
    public DataSource localDataSource() {
        return  DruidDataSourceBuilder.create().build();
    }

    /*----------------------------------------------------------------------------*/
    /*                           事务配置                                         */
    /*----------------------------------------------------------------------------*/

    /**
     * test事务
     * @param dataSource
     * @return
     */
    @Bean
    @Primary
    public PlatformTransactionManager testTransactionManager(@Qualifier("testDataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * dev事务
     * @param dataSource
     * @return
     */
    @Bean

    public PlatformTransactionManager devTransactionManager(@Qualifier("devDataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * local事务
     * @param dataSource
     * @return
     */
    @Bean

    public PlatformTransactionManager localTransactionManager(@Qualifier("localDataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
