package org.ysikorsky.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class ProcessorTask {

	public int number;
	public ProcessorTaskState state;
	public String id;
	public int answer;
	public LocalDateTime localDateTimeCreated;
	public LocalDateTime localDateTimeDone;

	@Autowired
	public ProcessorTask(int number) {
		this.number = number;
		this.id = UUID.randomUUID().toString();
		this.state = ProcessorTaskState.CREATED;
		localDateTimeCreated = LocalDateTime.now();
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
