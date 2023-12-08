package org.ysikorsky.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Request {

	public String idTask;
	public int number;
	@Autowired
	public Request(int number) {

		this.number = number;

	}

	public int getNumber() {

		return number;

	}


}
