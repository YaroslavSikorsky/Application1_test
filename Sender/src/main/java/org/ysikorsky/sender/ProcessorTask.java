package org.ysikorsky.sender;


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

	public int getNumber() {

		return number;

	}

	public String getId() {
		return id;
	}

	public int getAnswer() {

		return answer;

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
