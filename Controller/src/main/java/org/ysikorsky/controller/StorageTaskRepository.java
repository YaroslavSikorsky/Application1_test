package org.ysikorsky.controller;


import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface StorageTaskRepository extends CrudRepository<StorageTask, Integer> {

	//____________________________ TEST

	@Query("SELECT * FROM public.tasks WHERE id = :id ORDER BY local_date_time_created ASC")
	Optional<StorageTask> findById(String id);

	//@Query("SELECT * FROM public.tasks WHERE state = 'CREATED' LIMIT 1")
	@Query("SELECT * FROM public.tasks WHERE state = 'CREATED' ORDER BY local_date_time_created ASC LIMIT 10")
	List<StorageTask> firstCreatedTask();

	@Query("SELECT * FROM public.tasks ORDER BY local_date_time_created ASC")
	Iterable<StorageTask> findAll();

	@Query("SELECT COUNT(*) FROM public.senders")
	Integer countSenderSpeedById();

	@Query("SELECT COUNT(*) FROM public.processor_speed")
	Integer countProcessorSpeedById();

	//____________________________ TASK

//	@Modifying
//	@Query("INSERT INTO public.tasks (id, number, state, local_date_time_created) VALUES (:id, :number, :state, :localDateTimeCreated)")
//	Integer save(String id, Integer number, String state, Timestamp localDateTimeCreated);
	@Modifying
	@Query("INSERT INTO public.tasks (id, number, state) VALUES (:id, :number, :state)")
	Integer save(String id, Integer number, String state);

	@Modifying
	@Query("UPDATE public.tasks SET state = :state WHERE id = :id")
	Integer saveInProgressState(String state, String id);

	@Modifying
	@Query("UPDATE public.tasks SET local_date_time_created = :localDateTimeCreated WHERE id = :id")
	Integer saveInProgressTime(Timestamp localDateTimeCreated, String id);

	@Modifying
	@Query("UPDATE public.tasks SET answer = :answer, state = :state, local_date_time_done = :localDateTimeDone WHERE id = :id")
	Integer saveDoneData(Integer answer, String state, Timestamp localDateTimeDone, String id);

	//____________________________ SENDER

	@Modifying
	@Query("INSERT INTO public.senders (id, speed) VALUES (:id, :senderSpeed)")
	//@Query("UPDATE public.senders SET speed =: senderSpeed")
	Integer saveSenderSpeed(Integer id, Integer senderSpeed);

	@Modifying
	@Query("UPDATE public.senders SET speed = :senderSpeed WHERE id = :id ")
	Integer updateSpeed(Integer id, Integer senderSpeed);

	@Query("SELECT speed FROM public.senders WHERE id = :id ")
	Integer getSpeed(Integer id);

	//____________________________ PROCESSOR

	@Modifying
	@Query("INSERT INTO public.processor_speed (id, speed) VALUES (:id, :processorSpeed)")
	Integer saveProcessorSpeed(Integer id, Integer processorSpeed);

	@Modifying
	@Query("UPDATE public.processor_speed SET speed = :processorSpeed WHERE id = :id ")
	Integer updateProcessorSpeed(Integer id, Integer processorSpeed);

	@Query("SELECT speed FROM public.processor_speed WHERE id = :id ")
	Integer getProcessorSpeed(Integer id);
}