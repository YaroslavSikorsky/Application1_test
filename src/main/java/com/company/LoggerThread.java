package com.company;
import company33.TaskStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.*;

public class LoggerThread extends Thread {
	private TaskService taskService;
	private static final Logger logger = Logger.getLogger(LoggerThread.class.getName());
	private static Map<String, String> taskStateMap = new HashMap<>();

	public LoggerThread(TaskService taskService) {
		this.taskService = taskService;
	}

	@Override
	public void run() {
		while (true) {
			try {
				synchronized (taskStateMap) {
					List<Task> tasks = taskService.getAllTasks();
					for (Task task : tasks) {
						String taskId = task.getId();
						String taskState = task.getState().toString();
						String previousState = taskStateMap.get(taskId);
						if (previousState == null || !previousState.equals(taskState)) {
							logTaskStatus(taskId, task.getNumber(), taskState);
							taskStateMap.put(taskId, taskState);
						}
					}
				}
				Thread.sleep(500);
			} catch (InterruptedException ex) {

			}
		}
	}

	private void logTaskStatus(String taskId, int taskNumber, String taskState) {
		String logMessage = "Task id: " + taskId + " Task number: " + taskNumber + " has been " + taskState + ".";
		logger.info(logMessage);
	}

}