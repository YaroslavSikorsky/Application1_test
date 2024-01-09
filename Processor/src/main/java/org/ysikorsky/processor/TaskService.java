package org.ysikorsky.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ysikorsky.storage.StorageTask;
import org.ysikorsky.storage.StorageTaskState;
import org.ysikorsky.storage.TaskStorage;

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

	public List<ProcessorTask> getAllTasks() {
		return taskStorage.findAll().stream()
				.map(TaskConverter::convertToProcessorTask)
				.toList();
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

