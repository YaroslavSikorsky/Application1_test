package com.company;

public class Service {


	public Service() {

	}

	public int calculate(int number) {
		int resolve = 0;
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				resolve++;
			}
		}
		return resolve;
	}


}
