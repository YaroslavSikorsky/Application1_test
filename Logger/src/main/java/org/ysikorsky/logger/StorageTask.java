package org.ysikorsky.logger;


import org.springframework.data.annotation.Id;
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

	public int getNumber() {
		return number;
	}

	public StorageTaskState getState() {
		return state;
	}

	public int getAnswer() {
		return answer;
	}

	public LocalDateTime getLocalDateTimeCreated() {
		return localDateTimeCreated;
	}

	public LocalDateTime getLocalDateTimeDone() {
		return localDateTimeDone;
	}

}
