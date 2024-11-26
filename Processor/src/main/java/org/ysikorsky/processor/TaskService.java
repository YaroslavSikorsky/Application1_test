package org.ysikorsky.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Component
public class TaskService {

	int c = 0;

	private final TaskStorage taskStorage;

	@Autowired
	public TaskService(TaskStorage taskStorage) {
		this.taskStorage = taskStorage;
	}

	public int increaseProcessorSpeed(int id, int speed) {

		taskStorage.increaseProcessorSpeed(id, taskStorage.getProcessorSpeed(id) + speed);
		return taskStorage.getProcessorSpeed(id);
	}

	public int decreaseProcessorSpeed(int id, int speed) {

		taskStorage.decreaseProcessorSpeed(id, taskStorage.getProcessorSpeed(id) - speed);
		return taskStorage.getProcessorSpeed(id);
	}

	public int setProcessorSpeed(int x, int y){
		return taskStorage.setProcessorSpeed(x,y);
	}

	public int getProcessorSpeed(int id){
		return taskStorage.getProcessorSpeed(id);
	}

	public void truncateProcessorSpeed() {
		taskStorage.truncateProcessorSpeed();
	}

	public void accomplishTask() {
		List<StorageTask> firstCreatedTasks = taskStorage.firstCreatedTask();

		for (StorageTask storageTask : firstCreatedTasks) {
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

