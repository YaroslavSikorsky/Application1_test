package org.ysikorsky.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ysikorsky.storage.repository.StorageTaskRepository;


import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Component
public class TaskStorage {

	@Autowired
	public StorageTaskRepository storageTaskRepository;

	@Autowired
	public TaskStorage() {

	}

	public void saveTask(StorageTask storageTask) {
		storageTaskRepository.save(
				storageTask.getId(),
				storageTask.getNumber(),
				storageTask.getState().toString(),
				Timestamp.valueOf(storageTask.getLocalDateTimeCreated())
		);
	}

	public Optional<StorageTask> firstCreatedTask() {
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

	//	@Transactional
	public void updateTaskInProgress(StorageTask storageTask) {
		storageTaskRepository.saveInProgress(
				storageTask.getState().toString(),
				storageTask.getId()
		);
	}

	//	@Transactional
	public void updateTaskDone(StorageTask storageTask) {
		storageTaskRepository.saveDone(
				storageTask.getAnswer(),
				storageTask.getState().toString(),
				Timestamp.valueOf(storageTask.getLocalDateTimeDone()),
				storageTask.getId()
		);
	}

	public Optional<StorageTask> getTask(String id) {
		return storageTaskRepository.findById(id);
	}

}