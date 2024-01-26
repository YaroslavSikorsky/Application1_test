package org.ysikorsky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskProcessor extends Thread {

	public int processorSpeed;
	private final TaskService taskService;

	@Autowired
	public TaskProcessor(TaskService taskService) {
		this.taskService = taskService;
	}

	public int getProcessorSpeed() {
		return processorSpeed;
	}

	public void setProcessorSpeed(int senderSpeed) {
		this.processorSpeed = senderSpeed;
	}


	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(1);
				for (int i = 1; i <= processorSpeed; i++) {
					taskService.accomplishTask();
				}
			} catch (InterruptedException ex) {
				System.out.println(ex + "ex");
			}
		}
	}


}



