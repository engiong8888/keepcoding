package cn.keep.coding.base.db;

import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @ClassName SimpleMybatisDao
 * @Description mybatis通用dao
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 */
public class SimpleMybatisDao {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 查询列表
	 * @param statement
	 * @param parameter
	 * @return
	 */
	public List<Object> selectList(String statement, Object parameter) {
		List<Object> result = this.getSqlSessionTemplate().selectList(statement, parameter); 
		return result;
	}
	
	/**
	 * 查询列表
	 * @param statement
	 * @param parameter
	 * @param clazz 列表参数类型
	 * @return
	 */
	public <T> List<T> selectList(String statement, Object parameter, Class<T> clazz) {
		List<T> result = this.getSqlSessionTemplate().selectList(statement, parameter); 
		return result;
	}
	
	/**
	 * 查询单条记录
	 * @param statement
	 * @param parameter
	 * @return
	 */
	public Object selectOne(String statement, Object parameter) {
		Object result = null;
		result = this.getSqlSessionTemplate().selectOne(statement, parameter);
		return result;
	}
	
	/**
	 * 查询单条记录
	 * @param <T>
	 * @param statement
	 * @param parameter
	 * @param clazz 列表参数类型
	 * @return
	 */
	public <T> T selectOne(String statement, Object parameter, Class<T> clazz) {
		T result = null;
		result = this.getSqlSessionTemplate().selectOne(statement, parameter);
		return result;
	}
	
	/**
	 * 插入记录
	 * @param statement
	 * @param parameter
	 * @return
	 */
	public int insert(String statement, Object parameter) {
		int result = -1;
		result = this.getSqlSessionTemplate().insert(statement, parameter);
		return result;
	}
	
	/**
	 * 删除记录
	 * @param statement
	 * @param parameter
	 * @return
	 */
	public int delete(String statement, Object parameter) {
		int result = -1;
		result = this.getSqlSessionTemplate().delete(statement, parameter);
		return result;
	}
	
	/**
	 * 修改记录
	 * @param statement
	 * @param parameter
	 * @return
	 */
	public int update(String statement, Object parameter) {
		int result = -1;
		result = this.getSqlSessionTemplate().update(statement, parameter);
		return result;
	}
	
	/**
	 * 动态设置数据源
	 * @param dataSource
	 * @throws Exception
	 */
	public void setDataSource(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		Resource configLocation = new ClassPathResource("mybatis/mybatis-sqlmap.xml");
		ssfb.setDataSource(dataSource);
		ssfb.setConfigLocation(configLocation);
		this.sqlSessionTemplate = new SqlSessionTemplate(ssfb.getObject());
	}
	
	/**
	 * 设置Mybatis Template(动态设置多数据源)
	 * @param dataSource 数据源
	 * @param mfPath 映射文件的类文件路径
	 * @throws Exception
	 */
	public void setSqlSessionTemplate(DataSource dataSource, String mfPath) throws Exception {
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		Resource configLocation = new ClassPathResource(mfPath);
		ssfb.setDataSource(dataSource);
		ssfb.setConfigLocation(configLocation);
		this.sqlSessionTemplate = new SqlSessionTemplate(ssfb.getObject());
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}
