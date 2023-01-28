package com.company;

public class Service {

	public int number;
	public int resolve;
	public TaskState taskState;

	public Service(Task task) {
		this.number = task.getNumber();
		this.taskState = task.getState();
	}

	public int calculate() {
		int count = 0;
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				count++;
			}
		}
		resolve = count;
		taskState = TaskState.DONE;
		return resolve;
	}


}
