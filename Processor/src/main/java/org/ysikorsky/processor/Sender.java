package org.ysikorsky.processor;

public class Sender {

	public Receiver receiver;

	public Sender(Receiver receiver) {

		this.receiver = receiver;

	}


	public String sendRequestTask() {

		NumbersGenerator numbersGenerator = new NumbersGenerator();
		Request request = new Request(numbersGenerator.generateNumber());
		return receiver.handleRequest(request).getIdTask();

	}
}


