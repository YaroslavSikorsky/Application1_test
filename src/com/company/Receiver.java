package com.company;

public class Receiver {

	private final TaskManager taskManager;

	public Receiver(TaskManager taskManager) {

		this.taskManager = taskManager;

	}

	public String handleRequest(Request request) {

		Task task = new Task(request.getNumber());
		System.out.println(task.getNumber());
		System.out.println(task.getState());
		taskManager.saveTask(task);
		TaskProcessor taskProcessor = new TaskProcessor(task);
		taskProcessor.processingTask();
		System.out.println(task.getState());
		Response response = new Response(task.getId());
		return response.getIdTask();

	}

	public int handleRequestResolve(Request request) {

		Response response = new Response();
		response.setResolve(taskManager.getTask());
		System.out.println(response.getResolve());
		return response.getResolve();

	}


}