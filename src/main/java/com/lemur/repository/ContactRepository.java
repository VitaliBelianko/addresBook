package com.lemur.repository;

import com.lemur.entity.DomainObject;

import java.util.Set;

/**
 * Created by Виталий on 30.10.2016.
 */
public interface ContactRepository<V extends DomainObject> {
	void persist(V object);

	void delete(V object);

	Set<String> getRandomData();
}
