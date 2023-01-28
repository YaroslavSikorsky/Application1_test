package com.company;

public class Receiver {

	private final TaskManager taskManager;

	public Receiver(TaskManager taskManager) {

		this.taskManager = taskManager;

	}

	//сохраняет и возвращает уникальный идентификатор
	public String handleRequest(Request request) {

		Task task = new Task(request.getNumber()); //где то тут потом попросить посчитать resolve?
		System.out.println(task.getNumber());
		taskManager.saveTask(task);
		Response response = new Response(task.getId());
		System.out.println(response.getIdTask());
		return response.getIdTask();

	}

//	public int handleRequestEndTask(Request request) {
//
//		Response response = new Response(request.getIdTask());
//		response.setTaskEndData(taskManager.getTaskById(request.getIdTask()));
//		return response.getTaskEndData();
//
//	}


}