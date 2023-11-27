package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskStorage {

	public List<Task> tasks = new ArrayList<>();

	public void saveTask(Task task) {
		tasks.add(task);
	}

	public List<Task> allTasks() {
		return tasks.stream()
				.toList();
	}

	public Task findFirstCreated() {
		Optional<Task> firstInProgressTask = tasks.stream()
				.filter(task -> task.getState() == TaskState.CREATED)
				.findFirst();
		return firstInProgressTask.orElse(null);
	}

}
