package com.company;

public class Service {

	public int taskData;
	public int taskEndData;
	public TaskState taskState;

	public Service(Task task) {
		this.taskData = task.getData();
		this.taskState = task.getState();
	}

	public int calculate() {
		int count = 0;
		for (int i = taskData; i >= 1; i--) {
			if (taskData % i == 0) {
				count++;
			}
		}
		taskEndData = count;
		System.out.println(count);

		return taskEndData;

	}

	public void sss(Task task) {
		if (task.getState() == TaskState.DONE) {
			this.taskState = TaskState.DONE;
			System.out.println(taskState);
		}

	}

}
