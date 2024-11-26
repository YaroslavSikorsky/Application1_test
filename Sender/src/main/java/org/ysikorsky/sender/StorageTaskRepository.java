package org.ysikorsky.sender;


import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface StorageTaskRepository extends CrudRepository<StorageTask, Integer> {


	//____________________________ TASKS TABLE

	@Modifying
	@Query("INSERT INTO public.tasks (id, number, state, counter, version) VALUES (:id, :number, :state, :counter, :version)")
	Integer save(String id, Integer number, String state, Integer counter, Integer version);

	//____________________________ SENDERS TABLE

	@Modifying
	@Query("INSERT INTO public.senders (id, speed) VALUES (:id, :senderSpeed)")
	Integer saveSenderSpeed(Integer id, Integer senderSpeed);

	@Modifying
	@Query("UPDATE public.senders SET speed = :senderSpeed WHERE id = :id ")
	Integer updateSpeed(Integer id, Integer senderSpeed);

	@Query("SELECT speed FROM public.senders WHERE id = :id ")
	Integer getSpeed(Integer id);

	@Modifying
	@Query(value = "TRUNCATE TABLE public.senders")
	void truncateSenderSpeed();

}