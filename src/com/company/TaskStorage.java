package com.company;

import java.util.ArrayList;
import java.util.List;

public class TaskStorage {

	public List<Task> tasks = new ArrayList<>();

	public void saveTask(Task task) {

		tasks.add(task);

	}

//	public double findTaskById(String id) {
//
//		return tasks.stream()
//				.filter(s -> s.getId().equals(id))
//				.filter(s -> s.getState() == TaskState.DONE)
//				.mapToInt(Task::getEndData).average().getAsDouble();
//
//	}

}
