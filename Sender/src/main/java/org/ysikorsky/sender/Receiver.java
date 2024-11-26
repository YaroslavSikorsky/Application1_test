package org.ysikorsky.sender;

import org.springframework.stereotype.Component;


@Component
public class Receiver {

	private final TaskManager taskManager;

	public Receiver(TaskManager taskManager) {

		this.taskManager = taskManager;

	}

	public int getSenderSpeed(int id){
		return taskManager.getSenderSpeed(id);
	}

	public Response handleRequest(Request request) {

		ProcessorTask task = new ProcessorTask(request.getNumber());
		taskManager.saveTask(task);
		Response response = new Response(task.getId().toString());
		return response;

	}

}