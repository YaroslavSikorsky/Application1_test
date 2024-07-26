package org.ysikorsky.controller;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

//@Repository
//public interface SenderRepository extends CrudRepository<Sender,Integer>{
//
//	@Modifying // переписать, создать таблицу и типа должно работать
//	@Query("INSERT INTO public.sender (sender_speed) VALUES (:senderSpeed)")
//	Integer save(Integer senderSpeed);
//
//}


