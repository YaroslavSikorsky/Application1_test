package org.ysikorsky.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.*;

// TODO когда компонент создатся - сразу стартанет, как вызвать чтото при создании (аннотация)
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
					Thread.sleep(1);
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
				Thread.sleep(1);
			} catch (InterruptedException ex) {
				System.out.println("logger: InterruptedException!!!!!!!");
			} catch (IllegalArgumentException ex2) {
				System.out.println("logger: IllegalArgumentException!!!!!!!" + ex2);
			} catch (NullPointerException ex3) {
				System.out.println("logger: NullPointerException!!!!!!!" + ex3);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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