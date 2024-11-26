package org.ysikorsky.processor;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("tasks")
public class StorageTask {

	@Id
	public String id;
	public int number;
	public StorageTaskState state;
	public int answer;
	public LocalDateTime localDateTimeCreated;
	public LocalDateTime localDateTimeDone;
	private int version;

	public StorageTask(int number) {
		this.number = number;
		this.id = UUID.randomUUID().toString();
		this.state = StorageTaskState.CREATED;
		this.version = 0;
	}

	public int getVersion() {
		return version;
	}

	@Override
	public String toString() {
		return "StorageTask{" +
				"id='" + id + '\'' +
				", number=" + number +
				", state=" + state +
				", answer=" + answer +
				", localDateTimeCreated=" + localDateTimeCreated +
				", localDateTimeDone=" + localDateTimeDone +
				'}';
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public StorageTaskState getState() {
		return state;
	}

	public void setState(StorageTaskState state) {
		this.state = state;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public LocalDateTime getLocalDateTimeCreated() {
		return localDateTimeCreated;
	}

	public void setLocalDateTimeCreated(LocalDateTime localDateTimeCreated) {
		this.localDateTimeCreated = localDateTimeCreated;
	}

	public LocalDateTime getLocalDateTimeDone() {
		return localDateTimeDone;
	}

	public void setLocalDateTimeDone(LocalDateTime localDateTimeDone) {
		this.localDateTimeDone = localDateTimeDone;
	}
}
