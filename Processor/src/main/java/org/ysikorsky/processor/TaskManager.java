package org.ysikorsky.processor;


import org.ysikorsky.storage.TaskStorage;

public class TaskManager {

	private final TaskStorage taskStorage;

	public TaskManager(TaskStorage taskStorage) {

		this.taskStorage = taskStorage;

	}

	public void saveTask(ProcessorTask task) {

		taskStorage.saveTask(TaskConverter.convertToStorageTask(task));

	}

}
