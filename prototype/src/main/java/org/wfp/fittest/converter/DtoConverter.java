package org.wfp.fittest.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wfp.fittest.dto.AbstractDto;
import org.wfp.fittest.entity.EntityId;
import org.wfp.fittest.repository.ActivityRepository;

@Service
@Transactional(readOnly = true)
public class DtoConverter {
	@Autowired
	private ActivityRepository activityRepsository;
	
	public <D extends AbstractDto, E extends EntityId> D entityToDto(E entity) {
		return EntityConverter.toBean(entity);
	}
	
	public <D extends AbstractDto, E extends EntityId> List<D> entitiesToDtos(Iterable<E> entities) {
		return EntityConverter.toBeanList(entities);
	}
}
