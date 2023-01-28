package com.company;


public class Response {

	public String idTask;
	public int resolve;

	public Response(){

	}

	public Response(String id) {

		this.idTask = id;

	}

	public String getIdTask() {

		return idTask;

	}

	//потом использовать когда будет запрос по АЙДИ
//	public void setIdTask(String idTask) {
//
//		this.idTask = idTask;
//
//	}

	public int getResolve() {

		return resolve;

	}

	public void setResolve(int resolve) {

		this.resolve = resolve;

	}

}
