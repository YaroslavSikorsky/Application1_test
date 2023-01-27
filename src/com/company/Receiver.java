package com.company;

public class Receiver {

	private final TaskManager taskManager;

	public Receiver(TaskManager taskManager) {

		this.taskManager = taskManager;

	}

	public String handleRequest(Request request) {

		Task task = new Task(request.getTaskData());
		System.out.println(task.getData());
		taskManager.saveTask(task);
		request.setIdTask(task.getId());
		Response response = new Response(request.getIdTask());
		return response.getIdTask();

	}

	public int handleRequestEndTask(Request request) {

		taskManager.getTaskById(request.getIdTask()); // это надо передавать в response? это значение не используется, зачем я искал таски..тут проверка статуса?
		Response response = new Response(request.getIdTask());
		return response.getEndData();

	}


}