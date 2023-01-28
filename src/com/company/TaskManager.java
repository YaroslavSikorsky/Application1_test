package com.company;


public class TaskManager {

	private final TaskStorage taskStorage;

	public TaskManager(TaskStorage taskStorage) {

		this.taskStorage = taskStorage;

	}


	public void saveTask(Task task) {

		taskStorage.saveTask(task);

		//вычисление пока тут
		Service service = new Service(task);
		task.setResolve(service.calculate());
		task.setState(TaskState.DONE);

	}


	public int getTask() {

		return (int) taskStorage.findTask();

	}

}
