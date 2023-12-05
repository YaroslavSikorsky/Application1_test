package org.ysikorsky.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskStorage {

	public List<StorageTask> tasks = new ArrayList<>();

	public void saveTask(StorageTask task) {
		tasks.add(task);
	}

	public List<StorageTask> allTasks() {
		return tasks.stream()
				.toList();
	}

	public StorageTask findFirstCreated() {
		Optional<StorageTask> firstInProgressTask = tasks.stream()
				.filter(task -> task.getState() == StorageTaskState.CREATED)
				.findFirst();
		return firstInProgressTask.orElse(null);
	}

}
