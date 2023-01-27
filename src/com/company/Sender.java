package com.company;

public class Sender {

	public Receiver receiver;

	public Sender(Receiver receiver) {

		this.receiver = receiver;

	}

	public void goRequestNewTask(int data) {

		Request request = new Request(data);
		receiver.handleRequest(request);

	}

	public void goRequestEndTask(String id) {

		Request request = new Request(id);
		receiver.handleRequestEndTask(request);

	}


}


