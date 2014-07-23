package org.wfp.fittest.utility;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class AbstractRepositoryImpl<T, ID extends Serializable> extends
		SimpleJpaRepository<T, ID> implements AbstractRepository<T, ID> {

	@SuppressWarnings("unused")
	private EntityManager entityManager;

	public AbstractRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}

//	@Override
//	public Boolean deleteCheck(ID id) {
//		if (exists(id)) {
//			delete(id);
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
}
