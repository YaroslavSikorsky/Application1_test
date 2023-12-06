package org.ysikorsky.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskStorage {

	public final List<StorageTask> tasks = new ArrayList<>();

	public void saveTask(StorageTask task) {
		tasks.add(task);
	}

	public List<StorageTask> allTasks() {
		return tasks.stream()
				.toList();
	}

	// TODO работает ли эта синхронизация?
	public StorageTask findFirstCreated() {
		synchronized (tasks) {
			Optional<StorageTask> firstInProgressTask = tasks.stream()
					.filter(task -> task.getState() == StorageTaskState.CREATED)
					.findFirst();
			return firstInProgressTask.orElse(null);
		}
	}

}
