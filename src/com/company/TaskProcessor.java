package com.company;

public class TaskProcessor {

	public Task task;

	public TaskProcessor(Task task) {

		this.task = task;

	}

	public void processingTask() {

		task.setState(TaskState.INWORK);
		Service service = new Service(task);
		task.setResolve(service.calculate());
		task.setState(TaskState.DONE);

	}
}
