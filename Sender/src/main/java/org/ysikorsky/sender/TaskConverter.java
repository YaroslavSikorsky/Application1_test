package org.ysikorsky.sender;


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

	public static StorageTask convertToStorageTask(ProcessorTask task) {
		StorageTask storageTask = new StorageTask(task.getNumber());
		storageTask.setId(task.getId());
		storageTask.setNumber(task.getNumber());
		storageTask.setState(convertToStorageTaskState(task.getState()));
		storageTask.setAnswer(task.getAnswer());
		storageTask.setLocalDateTimeCreated(task.getLocalDateTimeCreated());
		storageTask.setLocalDateTimeDone(task.getLocalDateTimeDone());
		return storageTask;
	}

}