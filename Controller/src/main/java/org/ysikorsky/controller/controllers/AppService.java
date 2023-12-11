package org.ysikorsky.controller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ysikorsky.processor.LoggerThread;
import org.ysikorsky.processor.Sender;
import org.ysikorsky.processor.TaskProcessor;
import org.ysikorsky.storage.StorageTask;
import org.ysikorsky.storage.TaskStorage;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AppService {

	@Autowired
	private Sender sender;

	@Autowired
	private List<TaskProcessor> taskProcessorList;

	@Autowired
	private TaskStorage taskStorage;

	@Autowired
	private LoggerThread loggerThread;

	int taskProcessorCount = 0;

	// TODO скорость а не количество (в теле а не урле)
	public int increaseSpeed(int speed) {
		return sender.increaseSpeed(speed);
	}

	public int decreaseSpeed(int speed) {
		return sender.decreaseSpeed(speed);
	}

	public int currentSpeed() {
		return sender.getSenderSpeed();
	}

	public int senderStart() {
		return sender.senderStart();
	}

	@PostConstruct
	public void init() {
		loggerThread.start();
	}

	// TODO лист процессоров положил и стартанул
	public String addTaskProcessor() {
		String name = "";
		try {
			if (taskProcessorList.get(0).getState() == Thread.State.NEW) {
				name = taskProcessorList.get(0).getName();
				taskProcessorCount++;
				taskProcessorList.get(0).start();
				System.out.println("TaskProcessor running " + taskProcessorCount + " threads, name: " + name + "!");
			} else if (taskProcessorList.get(1).getState() == Thread.State.NEW) {
				name = taskProcessorList.get(1).getName();
				taskProcessorCount++;
				taskProcessorList.get(1).start();
				System.out.println("TaskProcessor running " + taskProcessorCount + " threads, name: " + name + "!");
			} else if (taskProcessorList.get(2).getState() == Thread.State.NEW) {
				name = taskProcessorList.get(2).getName();
				taskProcessorCount++;
				taskProcessorList.get(2).start();
				System.out.println("TaskProcessor running " + taskProcessorCount + " threads, name: " + name + "!");
			} else {
				System.out.println("MAX THREAD IS STARTED!!!!!!!!!");
			}
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			System.out.println("IndexOutOfBoundsException = " + indexOutOfBoundsException);
		}
		return "TaskProcessor running " + taskProcessorCount + " threads, name: " + name + "!";

	}

	public List<StorageTask> getTasks() {
		return taskStorage.allTasks();
	}
}
