package com.company;


public class Request {

	public String idTask;
	public int number;

	public Request() {

	}

	public Request(int number) {

		this.number = number;

	}
	//потом использовать когда будет запрос по АЙДИ
//	public String getIdTask() {
//
//		return idTask;
//
//	}
//
//	public void setIdTask(String id) {
//
//		this.idTask = id;
//
//	}

	public int getNumber() {

		return number;

	}


}
