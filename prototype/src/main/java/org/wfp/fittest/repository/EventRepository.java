package org.wfp.fittest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.wfp.fittest.entity.Event;
import org.wfp.fittest.repository.custom.EventRepositoryCustom;

public interface EventRepository extends CrudRepository<Event, Long>,
		EventRepositoryCustom {

	public List<Event> findByStartDateGreaterThanEqual(Date startDate);

	public List<Event> findByEndDateLessThanEqual(Date endDate);

	public List<Event> findByEvent(String eventName);

	public void deleteByEvent(String eventName);
}
