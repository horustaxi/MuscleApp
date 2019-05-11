package com.vas.muscleapp.services;

import com.vas.muscleapp.models.BaseEntity;

public interface BaseService<T extends BaseEntity, ID> {

	T save(T entity);

	T findById(ID id);

}
