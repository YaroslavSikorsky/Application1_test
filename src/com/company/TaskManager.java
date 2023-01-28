package com.company;

import java.util.List;


public class TaskManager {

	private final TaskStorage taskStorage;

	public TaskManager(TaskStorage taskStorage) {

		this.taskStorage = taskStorage;

	}


	public void saveTask(Task task) {

		taskStorage.saveTask(task);
		System.out.println(task.getState());

//		//вычисление пока тут
//		Service service = new Service(task);
//		service.calculate();
//		task.setState(TaskState.DONE);
//		service.sss(task);


	}

//	public int getTaskById(String id) {
//
//		return (int) taskStorage.findTaskById(id);
//
//	}


}
