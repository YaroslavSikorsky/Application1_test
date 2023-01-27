package com.company;


public class Request {

	public String idTask;
	public int taskData;

	public Request(String id) {

		this.idTask = id;


	}

	public Request(int taskData) {

		this.taskData = taskData;

	}

	public String getIdTask() {

		return idTask;

	}

	public void setIdTask(String id) {

		this.idTask = id;

	}


	public int getTaskData() {

		return taskData;

	}


}
