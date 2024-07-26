package org.ysikorsky.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Service
public class AppService {

	@Autowired
	private Sender sender;

	@Autowired
	private Processor processor;

	@Autowired
	private LoggerThread loggerThread;

	@Autowired
	private TaskStorage taskStorage;

	//____________________________ TEST

	public Iterable<StorageTask> getAllTasks() {
		return taskStorage.findAll();
	}

	public StorageTask createTask(StorageTask storageTask) {
		taskStorage.saveTask(storageTask);
		return storageTask;
	}

	public Optional<StorageTask> getTask(@PathVariable String id) {
		return taskStorage.getTask(id);
	}

	//____________________________ SENDER

	public int senderStart() {
		boolean exists = taskStorage.existsSenderSpeed();
		if (!exists) {
			taskStorage.setSenderSpeed(1, 1);
			sender.senderStart(1);
		} else {
			sender.decreaseSpeed(1, taskStorage.getSenderSpeed(1) - 1);
		}

		return taskStorage.getSenderSpeed(1);
	}

	public int increaseSpeed(int speed) {
		return sender.increaseSpeed(1, speed);
	}

	public int decreaseSpeed(int speed) {
		return sender.decreaseSpeed(1, speed);
	}

	public int currentSpeed() {
		return sender.getSenderSpeed(1);
	}

	//____________________________ PROCESSOR

	public String addTaskProcessor() {
		boolean exists = taskStorage.existsProcessorSpeed();
		if (!exists) {
			taskStorage.setProcessorSpeed(1, 1);
		} else {
			processor.decreaseSpeed(1, taskStorage.getProcessorSpeed(1) - 1);
		}
		return processor.addTaskProcessor();
	}

	public String getTaskProcessorCount() {
		return Integer.toString(processor.getTaskProcessorCount());
	}

	public int increaseSpeedProcessor(int speed) {
		return processor.increaseSpeed(1, speed);
	}

	public int decreaseSpeedProcessor(int speed) {
		return processor.decreaseSpeed(1, speed);
	}

	public int currentSpeedProcessor() {
		return taskStorage.getProcessorSpeed(1);
	}

	//____________________________ LOGGER

	@PostConstruct
	public void init() {
		loggerThread.start();
	}

}
