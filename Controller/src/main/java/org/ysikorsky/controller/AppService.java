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
		return sender.senderStart();
	}

	public int increaseSpeed(int speed) {
		return sender.increaseSpeed(speed);
	}

	public int decreaseSpeed(int speed) {
		return sender.decreaseSpeed(speed);
	}

	public int currentSpeed() {
		return sender.getSenderSpeed();
	}

	//____________________________ PROCESSOR

	public String addTaskProcessor() {
		return processor.addTaskProcessor();
	}

	public String getTaskProcessorCount(){
		return Integer.toString(processor.getTaskProcessorCount());
	}

	public int increaseSpeedProcessor(int speed) {
		return processor.increaseSpeed(speed);
	}

	public int decreaseSpeedProcessor(int speed) {
		return processor.decreaseSpeed(speed);
	}

	public int currentSpeedProcessor() {
		return processor.getProcessorSpeed();
	}

	//____________________________ LOGGER

	@PostConstruct
	public void init() {
		loggerThread.start();
	}

}
