package com.company;

import java.util.ArrayList;
import java.util.List;

public class TaskStorage {

	public List<Task> tasks = new ArrayList<>();

	public void saveTask(Task task) {

		tasks.add(task);

	}

	public double findTask() {

		return tasks.stream()
				//.filter(s -> s.getId().equals(id)) //потом использовать когда будет айди
				.filter(s -> s.getState() == TaskState.DONE)
				.mapToInt(Task::getResolve).average().getAsDouble();

	}


}
