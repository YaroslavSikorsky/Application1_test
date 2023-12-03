package org.ysikorsky.processor;

import java.util.Date;
import java.util.UUID;

public class Task {

	public int number;
	public TaskState state;
	public String id;
	public int answer;

	public Date	dateTimeCreated;
	public Date	dateTimeDone;

	public Task(int number) {
		this.number = number;
		this.id = UUID.randomUUID().toString();
		this.state = TaskState.CREATED;
		//this.dateTimeCreated(new Date())
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

	public int getNumber() {

		return number;

	}

	public int getAnswer() {

		return answer;

	}

	public void setAnswer(int answer) {

		this.answer = answer;

	}


}
