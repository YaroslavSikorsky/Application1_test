package com.company;

import java.util.Random;

public class NumbersGenerator {

		public int generateNumber() {

		Random random = new Random();
		return random.nextInt(999999999);

	}
}
