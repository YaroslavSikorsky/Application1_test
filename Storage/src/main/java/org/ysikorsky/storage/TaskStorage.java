package org.ysikorsky.storage;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TaskStorage {

	public final List<StorageTask> tasks = new ArrayList<>();

	public void saveTask(StorageTask task) {
		synchronized (tasks) {
			tasks.add(task);
		}
	}

	public List<StorageTask> allTasks() {
		synchronized (tasks) {
			return tasks.stream()
					.toList();
		}
	}

	// TODO работает ли эта синхронизация? - не работает
	public StorageTask findFirstCreated() {
		synchronized (tasks) {
			Optional<StorageTask> firstInProgressTask = tasks.stream()
					.filter(task -> task.getState() == StorageTaskState.CREATED)
					.findFirst();
			return firstInProgressTask.orElse(null);
		}
	}

	public static void main(String[] args) {

	}

}
