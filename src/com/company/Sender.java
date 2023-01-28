package com.company;

import java.util.Random;

public class Sender {

	public Receiver receiver;


	public Sender(Receiver receiver) {

		this.receiver = receiver;

	}

	//придумывает рандомное число и посылает запрос на подсчет, //получает айди задачи
	public void requestTask() {

		Request request = new Request(generateNumber());
		receiver.handleRequest(request);

	}

	public int generateNumber() {

		Random random = new Random();
		return random.nextInt(9999999); //добавить потом пару 9

	}

	public void requestResolve() {

		Request request = new Request();
		receiver.handleRequestResolve(request);

	}


}


