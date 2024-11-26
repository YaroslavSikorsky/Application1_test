package org.ysikorsky.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TaskService {

	private final TaskStorage taskStorage;

	//TODO вынести из сервиса?

	@Autowired
	public TaskService(TaskStorage taskStorage) {
		this.taskStorage = taskStorage;
	}

	public int getSenderSpeed(int x){
		return taskStorage.getSenderSpeed(x);
	}

	public int setSenderSpeed(int x, int y){
		return taskStorage.setSenderSpeed(x, y);
	}

	public void truncateSenderSpeed(){
		taskStorage.truncateSenderSpeed();
	}

}

