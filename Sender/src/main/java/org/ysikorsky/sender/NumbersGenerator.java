package org.ysikorsky.sender;


import java.util.Random;

public class NumbersGenerator {

	public Random random = new Random();

	public int generateNumber() {

		return random.nextInt(999999999);

	}
}
