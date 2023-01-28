package com.company;

import java.util.UUID;

public class Task {

	public int number;
	public TaskState state;
	public String id;
	public int resolve;

	public Task(int number) {
		this.number = number;
		this.id = UUID.randomUUID().toString();
		this.state = TaskState.ACTIVATE;
	}


	public TaskState getState() {

		return state;

	}
//
//	public void setState(TaskState state) {
//
//		this.state = state;
//
//	}

	public String getId() {

		return this.id;

	}

	public int getNumber() {

		return number;

	}

//	public int getResolve() {
//		return resolve;
//	}
//
//	public void setResolve(int endData) {
//		this.resolve = endData;
//	}


}
