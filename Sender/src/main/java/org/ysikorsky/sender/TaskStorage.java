package org.ysikorsky.sender;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class TaskStorage {

	private final StorageTaskRepository storageTaskRepository;

	@Autowired
	public TaskStorage(StorageTaskRepository storageTaskRepository) {
		this.storageTaskRepository = storageTaskRepository;
	}

	//____________________________ TASKS TABLE

	public void saveTask(StorageTask storageTask) {
		storageTaskRepository.save(
				storageTask.getId(),
				storageTask.getNumber(),
				storageTask.getState().toString(),//,
				0,
				storageTask.getVersion()
		);
	}

	//____________________________ SENDERS TABLE

	public void increaseSpeed(int id, int senderSpeed) {
		storageTaskRepository.updateSpeed(id, senderSpeed);
	}

	public void decreaseSpeed(int id, int senderSpeed) {
		storageTaskRepository.updateSpeed(id, senderSpeed);
	}

	public int setSenderSpeed(int id, int senderSpeed) {
		storageTaskRepository.saveSenderSpeed(id, senderSpeed);
		return storageTaskRepository.getSpeed(1);
	}

	public int getSenderSpeed(int id) {
		return storageTaskRepository.getSpeed(id);
	}

	public void truncateSenderSpeed() {
		storageTaskRepository.truncateSenderSpeed();
	}

}