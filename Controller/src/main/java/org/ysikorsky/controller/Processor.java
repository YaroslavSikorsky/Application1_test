package org.ysikorsky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Processor {

	@Autowired
	public TaskService taskService;
	@Autowired
	public TaskStorage taskStorage;
	int taskProcessorCount = 0;

	public List<TaskProcessor> taskProcessorList = new ArrayList<>();


	public int increaseSpeed(int id, int speed) {

//		for (TaskProcessor taskProcessor : taskProcessorList
//		) {
//			taskStorage.setProcessorSpeed(id,taskStorage.getProcessorSpeed(id) + speed);
//			//taskProcessor.setProcessorSpeed(taskStorage.getProcessorSpeed(1) + speed);
//		}
		taskStorage.increaseProcessorSpeed(id, taskStorage.getProcessorSpeed(id) + speed);
		return taskStorage.getProcessorSpeed(id);
	}

	public int decreaseSpeed(int id, int speed) {

//		for (TaskProcessor taskProcessor : taskProcessorList
//		) {
//			taskStorage.setProcessorSpeed(id,taskStorage.getProcessorSpeed(id) - speed);
//			//taskProcessor.setProcessorSpeed(taskStorage.getProcessorSpeed(1) - speed);
//		}
		taskStorage.decreaseProcessorSpeed(id, taskStorage.getProcessorSpeed(id) - speed);
		return taskStorage.getProcessorSpeed(id);
	}

	public String addTaskProcessor() {
		// todo try catch IndexOutOfBoundsException?

		taskProcessorList.add(new TaskProcessor(taskService, taskStorage));
		//taskProcessorList.get(taskProcessorCount).setProcessorSpeed(taskStorage.getProcessorSpeed(1));
		taskProcessorList.get(taskProcessorCount).start();
		System.out.println(
				" " + taskProcessorList.get(taskProcessorCount).getName() + " " +
						taskProcessorList.get(taskProcessorCount).getState() +
//						taskProcessorList.get(taskProcessorCount).getProcessorSpeed()
						taskStorage.getProcessorSpeed(1)
		);
		taskProcessorCount++;
		return taskProcessorList.get(taskProcessorCount - 1).getName();
	}

	public int getTaskProcessorCount() {
		return taskProcessorCount;
	}
	public int setDefaultTaskProcessorCount(){
		this.taskProcessorList = new ArrayList<>();
		return this.taskProcessorCount = 0;
	}
}
