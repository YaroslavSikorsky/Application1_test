package org.ysikorsky.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TaskProcessor extends Thread {

	private TaskService taskService;
	private Thread loggerThread;

	@Autowired
	public TaskProcessor(TaskService taskService) {
		this.taskService = taskService;
		if (loggerThread == null) {
			loggerThread = new LoggerThread(taskService);
		}
	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(5000);
				taskService.accomplishTask();
			} catch (InterruptedException ex) {
				System.out.println(ex + "ex");
			}
		}
	}

	public void start() {
		if (loggerThread.getState() == State.NEW) {
			loggerThread.start();
		}
		if (super.getState() == State.NEW) {
			super.start();
		}

	}
}



