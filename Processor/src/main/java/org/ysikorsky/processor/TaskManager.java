package org.ysikorsky.processor;

import org.springframework.stereotype.Component;
import org.ysikorsky.storage.TaskStorage;

@Component
public class TaskManager {

	private final TaskStorage taskStorage;

	public TaskManager(TaskStorage taskStorage) {

		this.taskStorage = taskStorage;

	}

	public void saveTask(ProcessorTask task) {

		taskStorage.saveTask(TaskConverter.convertToStorageTask(task));

	}

}
