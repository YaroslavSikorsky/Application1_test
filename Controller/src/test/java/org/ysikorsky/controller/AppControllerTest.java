package org.ysikorsky.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AppControllerTest {

	@Autowired
	private AppController appController;

	@DisplayName("Test senderStart")
	@Test
	void senderStart() {
		String expected = "Sender speed is 1";
		String actual = "";

		actual = appController.senderStart();
		System.out.println(actual);

		assertEquals(expected, actual);
	}

	@DisplayName("Test increaseSpeed")
	@Test
	@DirtiesContext
	void testIncreaseSpeed() {
		int number = 1;
		int expected = 3;
		int actual;

		actual = appController.increaseSpeed(number);
		System.out.println(actual);
		actual = appController.increaseSpeed(number);
		System.out.println(actual);

		assertEquals(expected, actual);

	}

	@DisplayName("Test increaseSpeed 2")
	@Test
	@DirtiesContext
	void testIncreaseSpeed2() {
		int number = 1;
		int expected = 3;
		int actual;

		actual = appController.increaseSpeed(number);
		System.out.println(actual);
		actual = appController.increaseSpeed(number);
		System.out.println(actual);

		assertEquals(expected, actual);

	}

	@DisplayName("Test decreaseSpeed")
	@Test
	@DirtiesContext
	void testDecreaseSpeed() {
		int number = 1;
		int expected = 0;
		int actual;

		actual = appController.decreaseSpeed(number);
		System.out.println(actual);

		assertEquals(expected, actual);

	}

	@DisplayName("Test addTaskProcessor")
	@Test
	void addTaskProcessor() {
		String expected = "Current starting processor name = Thread-5";
		String actual;

		actual = appController.addTaskProcessor();
		System.out.println(actual);

		assertEquals(expected, actual);

	}

	@DisplayName("Test getTaskProcessorCount")
	@Test
	void getTaskProcessorCount() {
		String expected = "Current processor count is 1";
		String actual;

		actual = appController.getTaskProcessorCount();
		System.out.println(actual);

		assertEquals(expected, actual);

	}

	@DisplayName("Test createTask")
	@Test
	void createTask() {
		ResponseEntity<StorageTask> expected = null;
		ResponseEntity<StorageTask> actual;

		actual = appController.createTask(new StorageTask(12312312));
		System.out.println(actual);

		assertEquals(expected, actual);

	}


}



