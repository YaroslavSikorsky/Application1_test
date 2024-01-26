package org.ysikorsky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ysikorsky.controller.*;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class TaskService {

	private final TaskStorage taskStorage;

	@Autowired
	public TaskService(TaskStorage taskStorage) {
		this.taskStorage = taskStorage;
	}

	public void accomplishTask() {
		Optional<StorageTask> firstCreatedTask = taskStorage.firstCreatedTask();
		if (firstCreatedTask.isPresent()) {
			StorageTask storageTask = firstCreatedTask.get();
			int number = storageTask.getNumber();
			storageTask.setState(StorageTaskState.IN_PROGRESS);

			taskStorage.updateTaskInProgress(storageTask);

			int calculate = calculate(number);
			storageTask.setAnswer(calculate);
			storageTask.setState(StorageTaskState.DONE);
			storageTask.setLocalDateTimeDone(LocalDateTime.now());

			taskStorage.updateTaskDone(storageTask);
		}
	}

	public int calculate(int number) {

		int answer = 0;
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				answer++;
			}
		}
		return answer;
	}
}

