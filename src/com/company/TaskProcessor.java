package com.company;


public class TaskProcessor extends Thread {

	public void processingTask(Task task) {

		task.setState(TaskState.INWORK);
		Service service = new Service();
		task.setAnswer(service.calculate(task.getNumber()));
		task.setState(TaskState.DONE);


	}

//		Thread run = new Thread(new Runnable() {
//
//			@Override
//			public void run() throws NoSuchElementException {
//				while (true) {
//					try {
//
//						task.setState(TaskState.INWORK);
//						Service service = new Service();
//						task.setAnswer(service.calculate(task.getNumber()));
//						task.setState(TaskState.DONE);
//
//						Thread.sleep(1000); //1000 - 1 сек
//					} catch (InterruptedException ex) {
//					}
//				}
//			}
//		});
//		run.start(); // заводим
//	}

}



