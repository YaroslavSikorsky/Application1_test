package com.company;

import java.util.UUID;

public class Main {

	public static void main(String[] args) {

		TaskStorage taskStorage = new TaskStorage();
		TaskManager taskManager = new TaskManager(taskStorage);
		Receiver receiver = new Receiver(taskManager);
		Sender sender = new Sender(receiver);

		sender.goRequestNewTask(99999999);
		sender.goRequestEndTask(UUID.randomUUID().toString());
	}
}
