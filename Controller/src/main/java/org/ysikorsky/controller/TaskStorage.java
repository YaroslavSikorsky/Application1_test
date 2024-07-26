package org.ysikorsky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Component
public class TaskStorage {

	private final StorageTaskRepository storageTaskRepository;

	@Autowired
	public TaskStorage(StorageTaskRepository storageTaskRepository) {
		this.storageTaskRepository = storageTaskRepository;
	}

	public void saveTask(StorageTask storageTask) {
		storageTaskRepository.save(
				storageTask.getId(),
				storageTask.getNumber(),
				storageTask.getState().toString()//,
				//Timestamp.valueOf(storageTask.getLocalDateTimeCreated())
		);
	}

	public List<StorageTask> firstCreatedTask() {
		return storageTaskRepository.firstCreatedTask();
	}

	public List<StorageTask> findAll() {
		Iterable<StorageTask> iterable = storageTaskRepository.findAll();
		Iterator<StorageTask> iterator = iterable.iterator();
		List<StorageTask> list = new ArrayList<>();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}

	boolean existsSenderSpeed() {
		return storageTaskRepository.countSenderSpeedById() > 0;
	}

	boolean existsProcessorSpeed() {
		return storageTaskRepository.countProcessorSpeedById() > 0;
	}


	public void updateTaskInProgress(StorageTask storageTask) {
		storageTaskRepository.saveInProgressState(
				storageTask.getState().toString(),
				storageTask.getId()
		);

		storageTaskRepository.saveInProgressTime(
				Timestamp.valueOf(LocalDateTime.now()),
				storageTask.getId()
		);
	}

	public void updateTaskDone(StorageTask storageTask) {
		storageTaskRepository.saveDoneData(
				storageTask.getAnswer(),
				storageTask.getState().toString(),
				Timestamp.valueOf(storageTask.getLocalDateTimeDone()),
				storageTask.getId()
		);
	}


	public Optional<StorageTask> getTask(String id) {
		return storageTaskRepository.findById(id);
	}

	//____________________________ SENDER

	public int setSenderSpeed(int id, int senderSpeed) {
		storageTaskRepository.saveSenderSpeed(id, senderSpeed);
		return storageTaskRepository.getSpeed(1);
	}

	public void increaseSpeed(int id, int senderSpeed) {
		storageTaskRepository.updateSpeed(id, senderSpeed);
	}

	public void decreaseSpeed(int id, int senderSpeed) {
		storageTaskRepository.updateSpeed(id, senderSpeed);
	}

	public int getSenderSpeed(int id) {
		return storageTaskRepository.getSpeed(id);
	}

	//____________________________ PROCESSOR

	public int setProcessorSpeed(int id, int processorSpeed) {
		storageTaskRepository.saveProcessorSpeed(id, processorSpeed);
		return storageTaskRepository.getProcessorSpeed(1);
	}

	public void increaseProcessorSpeed(int id, int processorSpeed) {
		storageTaskRepository.updateProcessorSpeed(id, processorSpeed);
	}

	public void decreaseProcessorSpeed(int id, int processorSpeed) {
		storageTaskRepository.updateProcessorSpeed(id, processorSpeed);
	}

	public int getProcessorSpeed(int id) {
		return storageTaskRepository.getProcessorSpeed(id);
	}

}