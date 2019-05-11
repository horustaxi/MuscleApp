package com.vas.muscleapp.services;

public interface BaseService<T, ID> {

	T save(T entity);

	T findById(ID id);;

}
