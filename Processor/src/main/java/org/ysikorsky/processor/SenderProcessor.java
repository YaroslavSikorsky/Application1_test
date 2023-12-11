package org.ysikorsky.processor;

public class SenderProcessor extends Thread {

	public int senderSpeed;
	public Receiver receiver;

	public SenderProcessor(int senderSpeed, Receiver receiver) {
		this.senderSpeed = senderSpeed;
		this.receiver = receiver;
	}

	public int getSenderSpeed() {
		return senderSpeed;
	}

	public void setSenderSpeed(int senderSpeed) {
		this.senderSpeed = senderSpeed;
	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(1000);
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
