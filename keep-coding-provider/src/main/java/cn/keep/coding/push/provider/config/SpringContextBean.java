package cn.keep.coding.push.provider.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextBean implements ApplicationContextAware {
	private static ApplicationContext context = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println(applicationContext);
		if (SpringContextBean.context == null) {
			SpringContextBean.context = applicationContext;
		}
	}

	public static ApplicationContext getApplicationContext() {
		return context;
	}
	/**
	 * 根据beanId获取对象
	 * @param beanId
	 * @return
	 */
	public static Object getBean(String beanId) {
		return getApplicationContext().getBean(beanId);
	}

	/**
	 * 根据class获取对象
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		return  getApplicationContext().getBean(clazz);
	}

	/**
	 * 根据beanId获取类型为clazz的对象
	 * @param beanId
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T getBean(String beanId, Class<T> clazz) {
		return (T) getApplicationContext().getBean(beanId, clazz);
	}


}
