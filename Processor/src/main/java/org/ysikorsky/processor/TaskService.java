package org.ysikorsky.processor;

import org.ysikorsky.storage.TaskStorage;

import java.util.List;


public class TaskService {

	private TaskStorage taskStorage;

	public TaskService(TaskStorage taskStorage) {
		this.taskStorage = taskStorage;
	}

	// TODO добавить конвертацию
	public List<ProcessorTask> getAllTasks() {
		List<ProcessorTask> processorTaskList = taskStorage.allTasks().stream()
				.map(s -> TaskConverter.convertToProcessorTask(s))
				.toList();
		return processorTaskList;
	}

	// TODO добавить конвертацию
	public void accomplishTask() {
		synchronized (taskStorage) {
			ProcessorTask firstCreatedTask = TaskConverter.convertToProcessorTask(taskStorage.findFirstCreated());
			if (firstCreatedTask != null) {
				int number = firstCreatedTask.getNumber();
				firstCreatedTask.setState(ProcessorTaskState.IN_PROGRESS);
				int calculate = calculate(number);
				firstCreatedTask.setAnswer(calculate);
				firstCreatedTask.setState(ProcessorTaskState.DONE);
				//firstCreatedTask.setdateTimeDone(new Date())
			}
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

