package org.wfp.fittest.utility;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.wfp.fittest.entity.Activity;

public interface AbstractRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

}
