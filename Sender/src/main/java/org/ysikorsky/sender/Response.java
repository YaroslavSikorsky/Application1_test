package org.ysikorsky.sender;

public class Response {

	public String idTask;
	public int result;

	public Response(String id) {

		this.idTask = id;

	}

	public String getIdTask() {

		return idTask;

	}
}
