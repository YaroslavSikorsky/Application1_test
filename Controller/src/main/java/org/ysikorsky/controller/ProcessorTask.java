package org.ysikorsky.controller;


import java.time.LocalDateTime;
import java.util.UUID;


public class ProcessorTask {

	public String id;
	public int number;
	public ProcessorTaskState state;
	public int answer;
	public LocalDateTime localDateTimeCreated;
	public LocalDateTime localDateTimeDone;

	public ProcessorTask(int number) {
		this.number = number;
		this.id = UUID.randomUUID().toString();
		this.state = ProcessorTaskState.CREATED;
		//localDateTimeCreated = LocalDateTime.now();
	}

	public void setLocalDateTimeCreated(LocalDateTime localDateTimeCreated) {
		this.localDateTimeCreated = localDateTimeCreated;
	}

	public void setLocalDateTimeDone(LocalDateTime localDateTimeDone) {
		this.localDateTimeDone = localDateTimeDone;
	}

	public LocalDateTime getLocalDateTimeCreated() {
		return localDateTimeCreated;
	}

	public LocalDateTime getLocalDateTimeDone() {
		return localDateTimeDone;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAnswer() {

		return answer;

	}

	public void setAnswer(int answer) {

		this.answer = answer;

	}

	@Override
	public String toString() {
		return "ProcessorTask{" +
				"id='" + id + '\'' +
				", number=" + number +
				", state=" + state +
				", answer=" + answer +
				", localDateTimeCreated=" + localDateTimeCreated +
				", localDateTimeDone=" + localDateTimeDone +
				'}';
	}
}
