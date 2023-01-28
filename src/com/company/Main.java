package com.company;

public class Main {

	public static void main(String[] args) {

		TaskStorage taskStorage = new TaskStorage();
		TaskManager taskManager = new TaskManager(taskStorage);
		Receiver receiver = new Receiver(taskManager);
		Sender sender = new Sender(receiver);

		sender.requestTask();
		//sender.requestResolve(UUID.randomUUID().toString()); //на что рассчитывал? этот генератор никогда не пересечется с генератором в таске
	}
}
