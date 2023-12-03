package org.ysikorsky.processor;

public class TaskProcessor extends Thread {

	private TaskService taskService;
	private Thread loggerThread;

	public TaskProcessor(TaskService taskService) {
		this.taskService = taskService;
		loggerThread = new LoggerThread(taskService);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				synchronized (taskService) {
					taskService.accomplishTask();
				}
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
			}
		}
	}

	public void start() {
		loggerThread.start();
		super.start();
	}
}



