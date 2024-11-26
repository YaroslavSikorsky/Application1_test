package org.ysikorsky.logger;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StorageTaskRepository extends CrudRepository<StorageTask, Integer> {

	//____________________________ TASKS TABLE

	@Query("SELECT * FROM public.tasks ORDER BY local_date_time_created ASC")
	Iterable<StorageTask> findAll();

}