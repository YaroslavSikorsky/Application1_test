package com.company;


import company33.TaskStorage;

public class TaskManager {

	private final TaskStorage taskStorage;

	public TaskManager(TaskStorage taskStorage) {

		this.taskStorage = taskStorage;

	}


	public void saveTask(Task task) {

		taskStorage.saveTask(task);

	}

}
