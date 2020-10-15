package cn.keep.coding.database.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识为数据库的字段
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 */
@Target(ElementType.FIELD) 
@Retention(RetentionPolicy.RUNTIME) 
public @interface Column {

	String name() default "";

	boolean allowNullUpdate() default  false;


}
