package com.company;

public class Receiver {

	private final TaskManager taskManager;

	public Receiver(TaskManager taskManager) {

		this.taskManager = taskManager;

	}

	public Response handleRequest(Request request) {

		Task task = new Task(request.getNumber());
		taskManager.saveTask(task);
		Response response = new Response(task.getId());
		return response;

	}

}