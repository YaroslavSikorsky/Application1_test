package org.ysikorsky.controller;


import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface StorageTaskRepository extends CrudRepository<StorageTask, Integer> {

	@Query("SELECT * FROM public.tasks ORDER BY local_date_time_created ASC")
	Iterable<StorageTask> findAll();

	//	@Modifying
//	@Query("INSERT INTO public.tasks (id, number, state, local_date_time_created) VALUES (:id, :number, :state, :localDateTimeCreated)")
//	Integer save(String id, Integer number, String state, Timestamp localDateTimeCreated);
	@Modifying
	@Query("INSERT INTO public.tasks (id, number, state) VALUES (:id, :number, :state)")
	Integer save(String id, Integer number, String state);


	@Query("SELECT * FROM public.tasks WHERE id = :id ORDER BY local_date_time_created ASC")
	Optional<StorageTask> findById(String id);

	//@Query("SELECT * FROM public.tasks WHERE state = 'CREATED' LIMIT 1")
	@Query("SELECT * FROM public.tasks WHERE state = 'CREATED' ORDER BY local_date_time_created ASC LIMIT 1")
	Optional<StorageTask> firstCreatedTask();

	@Modifying
	@Query("UPDATE public.tasks SET state = :state WHERE id = :id")
	Integer saveInProgress(String state, String id);

	@Modifying
	@Query("UPDATE public.tasks SET local_date_time_created = :localDateTimeCreated WHERE id = :id")
	Integer saveInProgressTime(Timestamp localDateTimeCreated, String id);

	@Modifying
	@Query("UPDATE public.tasks SET answer = :answer, state = :state, local_date_time_done = :localDateTimeDone WHERE id = :id")
	Integer saveDone(Integer answer, String state, Timestamp localDateTimeDone, String id);

}