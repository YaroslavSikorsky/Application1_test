package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskStorage {

	public List<Task> tasks = new ArrayList<>();

	public void saveTask(Task task) {

		tasks.add(task);

	}

	public List<Task> findTaskById(String id) {

		return tasks.stream()
				.filter(s -> s.getId().equals(id))
				.collect(Collectors.toList());

	}

}
