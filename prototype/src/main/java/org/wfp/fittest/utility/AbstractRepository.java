package org.wfp.fittest.utility;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

public interface AbstractRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

}
