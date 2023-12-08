package org.ysikorsky.processor;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ysikorsky.storage.StorageTask;
import org.ysikorsky.storage.StorageTaskState;
import org.ysikorsky.storage.TaskStorage;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class TaskService {

	private final TaskStorage taskStorage;

	@Autowired
	public TaskService(TaskStorage taskStorage) {
		this.taskStorage = taskStorage;
	}

	public List<ProcessorTask> getAllTasks() {

		return taskStorage.allTasks().stream()
				.map(TaskConverter::convertToProcessorTask)
				.toList();
	}

	public void accomplishTask() {

		StorageTask firstCreatedTask = taskStorage.findFirstCreated();
		if (firstCreatedTask != null) {
			int number = firstCreatedTask.getNumber();
			firstCreatedTask.setState(StorageTaskState.IN_PROGRESS);
			int calculate = calculate(number);
			firstCreatedTask.setAnswer(calculate);
			firstCreatedTask.setState(StorageTaskState.DONE);
			firstCreatedTask.setLocalDateTimeDone(LocalDateTime.now());
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

