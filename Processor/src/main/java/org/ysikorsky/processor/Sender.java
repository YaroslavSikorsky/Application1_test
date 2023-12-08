package org.ysikorsky.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	public Receiver receiver;

	@Autowired
	public Sender(Receiver receiver) {

		this.receiver = receiver;

	}

	public Sender() {


	}

	public String sendRequestTask() {

		NumbersGenerator numbersGenerator = new NumbersGenerator();
		Request request = new Request(numbersGenerator.generateNumber());
		return receiver.handleRequest(request).getIdTask();

	}
}


