package org.ysikorsky.processor;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppService {

	@Autowired
	private Processor processor;

	@Autowired
	private LoggerThread loggerThread;

	@Autowired
	private TaskService taskService;

	public String addTaskProcessor() {
		truncateProcessorSpeed();
		setDefaultProcessorSpeed();
		return processor.addTaskProcessor();
	}

	public String getTaskProcessorCount() {
		return Integer.toString(processor.getTaskProcessorCount());
	}

	//____________________________ PROCESSOR_SPEED TABLE

	public int increaseSpeedProcessor(int speed) {
		return processor.increaseSpeed(1, speed);
	}

	public int decreaseSpeedProcessor(int speed) {
		return processor.decreaseSpeed(1, speed);
	}

	public int currentSpeedProcessor() {
		return taskService.getProcessorSpeed(1);
	}

	public int setDefaultProcessorSpeed(){
		return taskService.setProcessorSpeed(1,1);
	}

	public int setDefaultTaskProcessorCount(){
		return  processor.setDefaultTaskProcessorCount();
	}

	public void truncateProcessorSpeed() {
		taskService.truncateProcessorSpeed();
	}

	//____________________________ LOGGER

	@PostConstruct
	public void init() {
		loggerThread.start();
	}

}
