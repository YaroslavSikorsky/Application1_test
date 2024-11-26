package org.ysikorsky.sender;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderProcessor extends Thread {

	public int senderSpeed = 1;
	public Receiver receiver;

	@Autowired
	public SenderProcessor(Receiver receiver) {
		this.receiver = receiver;

	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(1000);
				senderSpeed = receiver.getSenderSpeed(1);
				for (int i = 1; i <= senderSpeed; i++) {
					NumbersGenerator numbersGenerator = new NumbersGenerator();
					Request request = new Request(numbersGenerator.generateNumber());
					receiver.handleRequest(request);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
