package org.wfp.fittest.utility;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.wfp.fittest.entity.EntityId;

public class EntityConverter {

	private static final String BEAN_POSTFIX = "Bean";
	private static final String BEAN_NAMESPACE = "org.wfp.fittest.beans";

	public static <E extends EntityId> List<Long> toIdList(Iterable<E> entities) {
		List<Long> Ids = new ArrayList<Long>();
		for (EntityId entity : entities) {
			Ids.add(entity.getId());
		}
		return Ids;
	}

	@SuppressWarnings("unchecked")
	public static <B, T extends EntityId> B toBean(T entity) {
		try {
			String beanClassName = BEAN_NAMESPACE + "."
					+ entity.getClass().getSimpleName() + BEAN_POSTFIX;
			Class<B> beanClass = (Class<B>) Class.forName(beanClassName);
			B bean = beanClass.newInstance();
			BeanUtils.copyProperties(bean, entity);
			return bean;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <B, T extends EntityId> List<B> toBeanList(
			Iterable<T> entities) {
		List<B> beans = new ArrayList<B>();
		for (T entity : entities)
			beans.add((B) EntityConverter.toBean(entity));
		return beans;
	}

}
