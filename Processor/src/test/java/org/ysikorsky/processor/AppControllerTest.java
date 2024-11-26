package org.ysikorsky.processor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import org.ysikorsky.processor.AppController;
import org.ysikorsky.processor.StorageTask;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class AppControllerTest {

	@Autowired
	private AppController appController;

	@BeforeEach
	void clearBefore() {
		appController.truncateProcessorSpeed();
		appController.setDefaultProcessorSpeed();
	}


	@DisplayName("Test addTaskProcessor 1")
	@Test
	@Transactional
	void addTaskProcessor() {
		String expected = "Current starting processor name = Thread";

		String threadName = appController.addTaskProcessor();
		String actual = threadName.split("-")[0];

		assertEquals(expected, actual);
	}

	@DisplayName("Test addTaskProcessor 2")
	@Test
	@Transactional
	void addTaskProcessor2() {
		String expected1 = "Current starting processor name = Thread";
		String expected2 = "Current starting processor name = Thread";

		String threadName1 = appController.addTaskProcessor();
		String actual1 = threadName1.split("-")[0];
		String threadName2 = appController.addTaskProcessor();
		String actual2 = threadName2.split("-")[0];

		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
	}

	@DisplayName("Test getTaskProcessorCount 1")
	@Test
	@Transactional
	void getTaskProcessorCount() {
		String expected = "Current processor count is 0";
		String actual;

		appController.setDefaultTaskProcessorCount();

		actual = appController.getTaskProcessorCount();

		assertEquals(expected, actual);
	}

	@DisplayName("Test getTaskProcessorCount 2")
	@Test
	@Transactional
	void getTaskProcessorCount2() {
		String expected = "Current processor count is 1";
		String actual;

		appController.setDefaultTaskProcessorCount();

		appController.addTaskProcessor();

		actual = appController.getTaskProcessorCount();

		assertEquals(expected, actual);
	}

	@DisplayName("Test getTaskProcessorCount 3")
	@Test
	@Transactional
	void getTaskProcessorCount3() {
		String expected = "Current processor count is 2";
		String actual;

		appController.setDefaultTaskProcessorCount();

		appController.addTaskProcessor();
		appController.addTaskProcessor();

		actual = appController.getTaskProcessorCount();

		assertEquals(expected, actual);
	}


}



