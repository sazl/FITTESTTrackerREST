package org.wfp.fittest.utility;

public class JSONUtility {
	public static <B> BeanWrapper<B> beanWrapper(String wrapperName, B bean) {
		return new BeanWrapper<B>(wrapperName, bean);
	}
}
