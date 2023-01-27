package com.company;

import java.util.UUID;

public class Task {

	public int data;
	public TaskState state;
	public String id;
	public int endData;

	public Task(int data) {
		this.data = data;
		this.id = UUID.randomUUID().toString();
		this.state = TaskState.ACTIVATE;

	}

	public TaskState getState() {

		return state;

	}

	public void setState(TaskState state) {

		this.state = state;

	}

	public String getId() {

		return this.id;

	}

	public int getData() {
		return data;
	}

}
