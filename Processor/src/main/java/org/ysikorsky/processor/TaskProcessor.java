package org.ysikorsky.processor;

public class TaskProcessor extends Thread {

	private final TaskService taskService;

	public TaskProcessor(TaskService taskService) {
		this.taskService = taskService;
	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(1000);
				taskService.accomplishTask();
			} catch (InterruptedException ex) {
				System.out.println(ex + "ex");
			}
		}
	}

}



