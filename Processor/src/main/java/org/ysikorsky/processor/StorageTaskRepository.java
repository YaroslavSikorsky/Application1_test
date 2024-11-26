package org.ysikorsky.processor;


import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;


@Repository
public interface StorageTaskRepository extends CrudRepository<StorageTask, Integer> {

	//____________________________ TASKS TABLE

	@Modifying
	@Query("UPDATE public.tasks SET state = :state, local_date_time_created = :localDateTimeCreated, version =:version + 1, counter =:counter  WHERE id = :id and version =:version")
	Integer saveInProgressData(String state,Timestamp localDateTimeCreated,  int counter, Integer version, String id);

	@Modifying
	@Query("UPDATE public.tasks SET answer = :answer, state = :state, local_date_time_done = :localDateTimeDone, version =:version + 1 WHERE id = :id and version =:version")
	Integer saveDoneData(Integer answer, String state, Timestamp localDateTimeDone, Integer version, String id);

	@Query("SELECT counter FROM public.tasks WHERE id = :id ")
	Integer getCounterProcessor(String id);

	@Query("SELECT * FROM public.tasks WHERE state = 'CREATED' ORDER BY local_date_time_created ASC LIMIT 10")
	List<StorageTask> firstCreatedTask();

	//____________________________ PROCESSOR_SPEED TABLE

	@Modifying
	@Query("INSERT INTO public.processor_speed (id, speed) VALUES (:id, :processorSpeed)")
	Integer saveProcessorSpeed(Integer id, Integer processorSpeed);

	@Modifying
	@Query("UPDATE public.processor_speed SET speed = :processorSpeed WHERE id = :id ")
	Integer updateProcessorSpeed(Integer id, Integer processorSpeed);

	@Query("SELECT speed FROM public.processor_speed WHERE id = :id ")
	Integer getProcessorSpeed(Integer id);

	@Modifying
	@Query(value = "TRUNCATE TABLE public.processor_speed")
	void truncateProcessorSpeed();

}