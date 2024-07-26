package org.ysikorsky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskProcessor extends Thread {

	public TaskStorage taskStorage;
	public int processorSpeed = 1;
	private final TaskService taskService;

	public TaskProcessor(TaskService taskService, TaskStorage taskStorage) {
		this.taskService = taskService;
		this.taskStorage = taskStorage;
	}

//	public int getProcessorSpeed() {
//		return processorSpeed;
//	}
//
//	public void setProcessorSpeed(int senderSpeed) {
//		this.processorSpeed = senderSpeed;
//	}


	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(1);
				processorSpeed = taskStorage.getProcessorSpeed(1);
				for (int i = 1; i <= processorSpeed; i++) {
					taskService.accomplishTask();
				}
			} catch (InterruptedException ex) {
				System.out.println(ex + "ex");
			}
		}
	}


}



