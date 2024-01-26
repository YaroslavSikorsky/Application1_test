package org.ysikorsky.controller;


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

}
