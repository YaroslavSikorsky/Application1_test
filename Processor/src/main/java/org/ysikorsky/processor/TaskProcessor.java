package org.ysikorsky.processor;


import org.springframework.stereotype.Component;

@Component
public class TaskProcessor extends Thread {


	public int processorSpeed = 1;
	private final TaskService taskService;

	public TaskProcessor(TaskService taskService) {
		this.taskService = taskService;

	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(1);
				processorSpeed = taskService.getProcessorSpeed(1);
				for (int i = 1; i <= processorSpeed; i++) {
					taskService.accomplishTask();
				}
			} catch (InterruptedException ex) {
				System.out.println(ex + "ex");
			}
		}
	}


}



