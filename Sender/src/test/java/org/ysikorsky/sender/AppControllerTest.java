package org.ysikorsky.sender;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class AppControllerTest {

	@Autowired
	private AppController appController;

	@BeforeEach
	void clearBefore() {
		appController.truncateSenderSpeed();
		appController.setDefaultSenderSpeed();

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



