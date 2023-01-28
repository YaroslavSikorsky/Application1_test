package com.company;

public class Sender {

	public Receiver receiver;


	public Sender(Receiver receiver) {

		this.receiver = receiver;

	}

	public void sendRequestTask() {

		NumbersGenerator numbersGenerator = new NumbersGenerator();
		Request request = new Request(numbersGenerator.generateNumber());
		receiver.handleRequest(request);

	}


	public void sendRequestResolve() {

		Request request = new Request();
		receiver.handleRequestResolve(request);

	}


}


