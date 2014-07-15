package org.wfp.fittest.utility;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.wfp.fittest.entity.EntityId;
import org.wfp.fittest.repository.ActivityRepository;
import org.wfp.fittest.repository.ActivityRoleRepository;
import org.wfp.fittest.repository.ActivityTypeRepository;
import org.wfp.fittest.repository.CountryRepository;

public class EntityConverter {

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private ActivityRoleRepository activityRoleRepository;

	@Autowired
	private ActivityTypeRepository activityTypeRepository;
	
	@Autowired
	private CountryRepository countryRepository;

	private static final String BEAN_POSTFIX = "Bean";
	private static final String BEAN_NAMESPACE = "org.wfp.fittest.beans";
	private static final String ENTITY_NAMESPACE = "org.wfp.fittest.entity";

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

	@SuppressWarnings("unchecked")
	public static <B, T extends EntityId> T toEntity(B bean) {
		try {
			String beanClassName = bean.getClass().getSimpleName();
			String entityClassName = ENTITY_NAMESPACE
					+ "."
					+ beanClassName.substring(0, beanClassName.length()
							- BEAN_POSTFIX.length());
			Class<T> entityClass = (Class<T>) Class.forName(entityClassName);
			T entity = entityClass.newInstance();
			BeanUtils.copyProperties(entity, bean);
			return entity;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
