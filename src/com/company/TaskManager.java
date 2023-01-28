package com.company;


public class TaskManager {

	private final TaskStorage taskStorage;

	public TaskManager(TaskStorage taskStorage) {

		this.taskStorage = taskStorage;

	}

	public void saveTask(Task task) {

		taskStorage.saveTask(task);

	}


	public int getTask() {

		return (int) taskStorage.findTask();

	}

}
