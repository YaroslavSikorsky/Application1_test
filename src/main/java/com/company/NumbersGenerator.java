package com.company;

import java.util.Random;

public class NumbersGenerator {

	Random random = new Random();

	public int generateNumber() {

		return random.nextInt(999999999);

	}
}
