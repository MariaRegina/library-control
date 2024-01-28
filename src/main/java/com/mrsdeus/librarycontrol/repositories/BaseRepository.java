package com.mrsdeus.librarycontrol.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends Repository<T, ID> {
	
	@Query("SELECT T FROM #{#entityName} T WHERE T.baseModel.deletedAt IS NULL")
	Iterable<T> findAll();
	
	<S extends T> S save(S entity);

	@Query("SELECT T FROM #{#entityName} T WHERE T.id = ?1 AND T.baseModel.deletedAt IS NULL")
	Optional<T> findById(ID id);

	@Query("UPDATE #{#entityName} T SET T.baseModel.deletedAt = CURRENT_DATE WHERE T.id = ?1 ")
	void deleteById(ID id);
}
