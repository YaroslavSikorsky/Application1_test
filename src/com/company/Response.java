package com.company;


public class Response {

	public String idTask;
	public TaskState taskState; // надо ли
	public int endData;


	public Response(String id) {

		this.idTask = id;

	}

	public String getIdTask() {

		return idTask;

	}

	public int getEndData() {

		return endData;

	}
	
}
