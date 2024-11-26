package org.ysikorsky.logger;


public class TaskConverter {

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

	public static ProcessorTask convertToProcessorTask(StorageTask task) {
		ProcessorTask processorTask = new ProcessorTask(task.getNumber());
		processorTask.setId(task.getId());
		processorTask.setNumber(task.getNumber());
		processorTask.setState(convertToProcessorTaskState(task.getState()));
		processorTask.setAnswer(task.getAnswer());
		processorTask.setLocalDateTimeCreated(task.getLocalDateTimeCreated());
		processorTask.setLocalDateTimeDone(task.getLocalDateTimeDone());
		return processorTask;
	}

}