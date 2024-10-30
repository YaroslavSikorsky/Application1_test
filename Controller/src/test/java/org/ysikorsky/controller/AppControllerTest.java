package org.ysikorsky.controller;

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

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class AppControllerTest {

	@Autowired
	private AppController appController;

	@BeforeEach
	void clearBefore() {
		appController.truncateSenderSpeed();
		appController.truncateProcessorSpeed();

		appController.setDefaultSenderSpeed();
		appController.setDefaultProcessorSpeed();
	}

	@DisplayName("Test senderStart 1")
	@Test
	@Transactional
	public void senderStart() {
		String expected = "Sender speed is 1";
		String actual;

		actual = appController.senderStart();

		assertEquals(expected, actual, "\n" + "Data does not match!");
	}

	@DisplayName("Test increaseSpeed 1")
	@Test
	@Transactional
	//@DirtiesContext
	void testIncreaseSpeed() {
		int number = 1;
		int expected = 2;
		int actual;

		actual = appController.increaseSpeed(number);

		assertEquals(expected, actual, "\n" + "Data does not match!");
	}

	@DisplayName("Test increaseSpeed 2")
	@Test
	@Transactional
	void testIncreaseSpeed2() {
		int number = 1;
		int expected = 3;
		int actual;

		appController.increaseSpeed(number);
		actual = appController.increaseSpeed(number);

		assertEquals(expected, actual);
	}

	@DisplayName("Test decreaseSpeed 1")
	@Test
	@Transactional
	void testDecreaseSpeed() {
		int number = 1;
		int expected = 0;
		int actual;

		actual = appController.decreaseSpeed(number);

		assertEquals(expected, actual);
	}

	@DisplayName("Test decreaseSpeed 2")
	@Test
	@Transactional
	void testDecreaseSpeed2() {
		int number = 1;
		int expected = -1;
		int actual;

		appController.decreaseSpeed(number);
		actual = appController.decreaseSpeed(number);

		assertEquals(expected, actual);
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

	@DisplayName("Test createTask 1") // не удаляется из бд тк транкейт ток на сендер и процессор
	@Test
	@Transactional
	void createTask() {
		HttpStatus expected = HttpStatus.CREATED;
		ResponseEntity<StorageTask> actual;

		actual = appController.createTask(new StorageTask(12312312));

		assertEquals(expected, actual.getStatusCode());
	}

}



