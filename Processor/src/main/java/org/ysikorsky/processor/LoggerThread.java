package org.ysikorsky.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.*;

@Component
public class LoggerThread extends Thread {
	private final TaskService taskService;
	private static final Logger logger = Logger.getLogger(LoggerThread.class.getName());
	private static final Map<String, String> taskStateMap = new HashMap<>();

	@Autowired
	public LoggerThread(TaskService taskService) {
		this.taskService = taskService;
	}

	@Override
	public void run() {
		while (true) {
			try {
				synchronized (taskStateMap) {
					List<ProcessorTask> tasks = taskService.getAllTasks();
					for (ProcessorTask task : tasks) {
						String taskId = task.getId();
						String taskState = task.getState().toString();
						String previousState = taskStateMap.get(taskId);
						if (previousState == null || !previousState.equals(taskState)) {
							logTaskStatus(taskId, task.getNumber(), taskState, task.getLocalDateTimeCreated(), task.getLocalDateTimeDone());
							taskStateMap.put(taskId, taskState);
						}
					}
				}
				Thread.sleep(10);
			} catch (InterruptedException ex) {
				System.out.println("InterruptedException!!!!!!!");
			}
		}
	}

	private void logTaskStatus(String taskId, int taskNumber, String taskState, LocalDateTime localDateTimeCreated, LocalDateTime localDateTimeDone) {
		String logMessage = "Task id: " + taskId + ", \n" +
				" Task number: " + taskNumber + ", " +
				" has been " + taskState + ", " +
				"Time Created: " + localDateTimeCreated + ", " +
				"Time Done: " + localDateTimeDone;
		logger.info(logMessage);
	}

}