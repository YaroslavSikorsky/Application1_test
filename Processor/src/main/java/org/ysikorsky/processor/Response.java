package org.ysikorsky.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Response {

	public String idTask;
	public int result;
	@Autowired
	public Response(String id) {

		this.idTask = id;

	}

	public String getIdTask() {

		return idTask;

	}
}
