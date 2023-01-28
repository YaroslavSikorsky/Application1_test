package com.company;

import java.util.List;

public class Receiver {

	private final TaskManager taskManager;

	public Receiver(TaskManager taskManager) {

		this.taskManager = taskManager;

	}

	//сохраняет и возвращает уникальный идентификатор
	public String handleRequest(Request request) {

		Task task = new Task(request.getNumber()); //где то тут потом попросить посчитать resolve?
		System.out.println(task.getNumber());
		System.out.println(task.getState());
		taskManager.saveTask(task);
		System.out.println(task.getState());
		Response response = new Response(task.getId());
		return response.getIdTask();

	}

	//потом добавить использование АЙДИ
	public int handleRequestResolve(Request request) {

		Response response = new Response();
		response.setResolve(taskManager.getTask());
		System.out.println(response.getResolve());
		return response.getResolve();

	}


}