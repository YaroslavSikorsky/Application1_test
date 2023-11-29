package com.company;

import java.util.List;

import company33.TaskStorage;

public class TaskService {

	private TaskStorage taskStorage;

	public TaskService(TaskStorage taskStorage) {
		this.taskStorage = taskStorage;
	}

	public List<Task> getAllTasks() {
		return taskStorage.allTasks();
	}

	public void accomplishTask() {

		Task firstCreatedTask = taskStorage.findFirstCreated();
		if (firstCreatedTask != null) {
			int number = firstCreatedTask.getNumber();
			firstCreatedTask.setState(TaskState.IN_PROGRESS);
			int calculate = calculate(number);
			firstCreatedTask.setAnswer(calculate);
			firstCreatedTask.setState(TaskState.DONE);
		}
	}

	public int calculate(int number) {

		int answer = 0;
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				answer++;
			}
		}
		return answer;
	}
}

