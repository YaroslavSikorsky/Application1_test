package org.ysikorsky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Processor {

	@Autowired
	public TaskService taskService;
	public int processorSpeed = 1;
	int taskProcessorCount = 0;

	public List<TaskProcessor> taskProcessorList = new ArrayList<>();

	public int getProcessorSpeed() {
		return processorSpeed;
	}

	public int increaseSpeed(int speed) {
		processorSpeed += speed;
		for (TaskProcessor taskProcessor : taskProcessorList
		) {
			taskProcessor.setProcessorSpeed(processorSpeed);
		}
		return processorSpeed;
	}

	public int decreaseSpeed(int speed) {
		processorSpeed -= speed;
		for (TaskProcessor taskProcessor : taskProcessorList
		) {
			taskProcessor.setProcessorSpeed(processorSpeed);
		}
		return processorSpeed;
	}

	public String addTaskProcessor() {
		// todo try catch IndexOutOfBoundsException?
		taskProcessorList.add(new TaskProcessor(taskService));
		taskProcessorList.get(taskProcessorCount).setProcessorSpeed(processorSpeed);
		taskProcessorList.get(taskProcessorCount).start();
		System.out.println(
				" " +taskProcessorList.get(taskProcessorCount).getName() + " " +
						taskProcessorList.get(taskProcessorCount).getState() +
						taskProcessorList.get(taskProcessorCount).getProcessorSpeed()
		);
		taskProcessorCount++;
		return taskProcessorList.get(taskProcessorCount - 1).getName();
	}

	public int getTaskProcessorCount() {
		return taskProcessorCount;
	}
}
