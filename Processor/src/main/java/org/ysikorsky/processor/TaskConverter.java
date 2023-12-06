package org.ysikorsky.processor;

import org.ysikorsky.storage.StorageTask;
import org.ysikorsky.storage.StorageTaskState;


public class TaskConverter {

	public static StorageTaskState convertToStorageTaskState(ProcessorTaskState state) {
		if (state == ProcessorTaskState.CREATED) {
			return StorageTaskState.CREATED;
		} else if (state == ProcessorTaskState.IN_PROGRESS) {
			return StorageTaskState.IN_PROGRESS;
		} else if (state == ProcessorTaskState.DONE) {
			return StorageTaskState.DONE;
		} else {
			throw new IllegalArgumentException("ex");
		}
	}

	public static ProcessorTaskState convertToProcessorTaskState(StorageTaskState state) {
		if (state == StorageTaskState.CREATED) {
			return ProcessorTaskState.CREATED;
		} else if (state == StorageTaskState.IN_PROGRESS) {
			return ProcessorTaskState.IN_PROGRESS;
		} else if (state == StorageTaskState.DONE) {
			return ProcessorTaskState.DONE;
		} else {
			throw new IllegalArgumentException("ex");
		}
	}

	public static StorageTask convertToStorageTask(ProcessorTask task) {
		StorageTask storageTask = new StorageTask();
		storageTask.setNumber(task.getNumber());
		storageTask.setState(convertToStorageTaskState(task.getState()));
		storageTask.setId(task.getId());
		storageTask.setAnswer(task.getAnswer());
		return storageTask;
	}

	public static ProcessorTask convertToProcessorTask(StorageTask task) {
		ProcessorTask processorTask = new ProcessorTask();
		processorTask.setNumber(task.getNumber());
		processorTask.setState(convertToProcessorTaskState(task.getState()));
		processorTask.setId(task.getId());
		processorTask.setAnswer(task.getAnswer());
		return processorTask;
	}


}