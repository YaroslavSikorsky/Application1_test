package org.ysikorsky.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Processor {

	@Autowired
	public TaskService taskService;

	int taskProcessorCount = 0;

	public List<TaskProcessor> taskProcessorList = new ArrayList<>();


	public int increaseSpeed(int id, int speed) {

		taskService.increaseProcessorSpeed(id, taskService.getProcessorSpeed(id) + speed);
		return taskService.getProcessorSpeed(id);
	}

	public int decreaseSpeed(int id, int speed) {

		taskService.decreaseProcessorSpeed(id, taskService.getProcessorSpeed(id) - speed);
		return taskService.getProcessorSpeed(id);
	}

	public String addTaskProcessor() {
		// todo try catch IndexOutOfBoundsException?
		taskProcessorList.add(new TaskProcessor(taskService));
		taskProcessorList.get(taskProcessorCount).start();
		System.out.println(
				" " + taskProcessorList.get(taskProcessorCount).getName() + " " +
						taskProcessorList.get(taskProcessorCount).getState() +

						taskService.getProcessorSpeed(1)
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
