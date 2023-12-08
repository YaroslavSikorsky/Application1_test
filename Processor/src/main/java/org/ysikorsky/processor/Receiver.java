package org.ysikorsky.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	private final TaskManager taskManager;

	@Autowired
	public Receiver(TaskManager taskManager) {

		this.taskManager = taskManager;

	}

	public Response handleRequest(Request request) {

		ProcessorTask task = new ProcessorTask(request.getNumber());
		taskManager.saveTask(task);
		Response response = new Response(task.getId());
		return response;

	}

}