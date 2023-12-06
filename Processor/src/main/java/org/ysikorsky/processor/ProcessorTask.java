package org.ysikorsky.processor;

import java.util.UUID;

public class ProcessorTask {

	public int number;
	public ProcessorTaskState state;
	public String id;
	public int answer;
//	public Date dateTimeCreated;
//	public Date dateTimeDone;

	public ProcessorTask(int number) {
		this.number = number;
		this.id = UUID.randomUUID().toString();
		this.state = ProcessorTaskState.CREATED;
		//this.dateTimeCreated(new Date())
	}

	public ProcessorTask() {

	}

	public ProcessorTaskState getState() {
		return state;
	}

	public void setState(ProcessorTaskState state) {
		this.state = state;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {

		return number;

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
