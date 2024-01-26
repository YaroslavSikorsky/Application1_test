package org.ysikorsky.controller;


import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface StorageTaskRepository extends CrudRepository<StorageTask, Integer> {

	@Query("SELECT * FROM public.tasks ")
	Iterable<StorageTask> findAll();

	@Modifying
	@Query("INSERT INTO public.tasks (id, number, state, local_date_time_created) VALUES (:id, :number, :state, :localDateTimeCreated)")
	Integer save(String id, Integer number, String state, Timestamp localDateTimeCreated);

	@Query("SELECT * FROM public.tasks WHERE id = :id")
	Optional<StorageTask> findById(String id);

	@Query("SELECT * FROM public.tasks WHERE state = 'CREATED' LIMIT 1")
	Optional<StorageTask> firstCreatedTask();

	@Modifying
	@Query("UPDATE public.tasks SET state = :state WHERE id = :id")
	Integer saveInProgress(String state, String id);

	@Modifying
	@Query("UPDATE public.tasks SET answer = :answer, state = :state, local_date_time_done = :localDateTimeDone WHERE id = :id")
	Integer saveDone(Integer answer, String state, Timestamp localDateTimeDone, String id);

}