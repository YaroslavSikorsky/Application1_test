package org.ysikorsky.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
public class TaskStorage {

	private final StorageTaskRepository storageTaskRepository;

	@Autowired
	public TaskStorage(StorageTaskRepository storageTaskRepository) {
		this.storageTaskRepository = storageTaskRepository;
	}

	public List<StorageTask> findAll() {
		Iterable<StorageTask> iterable = storageTaskRepository.findAll();
		Iterator<StorageTask> iterator = iterable.iterator();
		List<StorageTask> list = new ArrayList<>();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}

}