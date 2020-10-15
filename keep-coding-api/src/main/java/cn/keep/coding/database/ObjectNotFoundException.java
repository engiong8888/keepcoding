package cn.keep.coding.database;

/**
 * 对像未找到异常<br>
 * 多用于根据某id查询一条记录，但此记录不存在
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 */
public class ObjectNotFoundException extends DBRuntimeException {

	public ObjectNotFoundException(String message) {
		super(message);
	}
		
	public ObjectNotFoundException(Exception e, String sql) {
		super(e, sql);
	 
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3403302876974180460L;

}
