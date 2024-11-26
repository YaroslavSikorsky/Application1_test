package org.ysikorsky.sender;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TaskManager {

	private final TaskStorage taskStorage;

	@Autowired
	public TaskManager(TaskStorage taskStorage) {
		this.taskStorage = taskStorage;
	}

	public void saveTask(ProcessorTask task) {
		taskStorage.saveTask(TaskConverter.convertToStorageTask(task));
	}

	public int increaseSpeed(int id, int speed) {
		taskStorage.increaseSpeed(id, taskStorage.getSenderSpeed(id) + speed);
		return taskStorage.getSenderSpeed(id);
	}

	public int decreaseSpeed(int id, int speed) {
		taskStorage.decreaseSpeed(id, taskStorage.getSenderSpeed(id) - speed);
		return taskStorage.getSenderSpeed(id);
	}

	public int getSenderSpeed(int id) {
		return taskStorage.getSenderSpeed(id);
	}

}
