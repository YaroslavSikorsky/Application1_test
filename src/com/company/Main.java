package com.company;

public class Main {

	public static void main(String[] args) {

		TaskStorage taskStorage = new TaskStorage();
		TaskManager taskManager = new TaskManager(taskStorage);
		Receiver receiver = new Receiver(taskManager);
		Sender sender = new Sender(receiver);

		sender.requestTask();
		sender.requestResolve(); //мы хотим получить по АЙДИ ответ, но как передавать айди я хз, поэтому пока просто список готовых тасков
	}
}
