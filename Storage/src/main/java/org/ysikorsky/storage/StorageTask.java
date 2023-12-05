package org.ysikorsky.storage;

import java.util.UUID;

public class StorageTask {

	public int number;
	public StorageTaskState state;
	public String id;
	public int answer;

	public StorageTask(int number) {
		this.number = number;
		this.id = UUID.randomUUID().toString();
		this.state = StorageTaskState.CREATED;
	}

	public StorageTask() {

	}

	public StorageTaskState getState() {
		return state;
	}

	public void setState(StorageTaskState state) {
		this.state = state;
	}

	public int getNumber() {

		return number;

	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public int getAnswer() {

		return answer;

	}

	public void setAnswer(int answer) {

		this.answer = answer;

	}

}
