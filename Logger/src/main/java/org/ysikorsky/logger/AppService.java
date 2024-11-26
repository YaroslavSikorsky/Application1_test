package org.ysikorsky.logger;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppService {

	@Autowired
	private LoggerThread loggerThread;

//	//____________________________ LOGGER

	@PostConstruct
	public void init() {
		loggerThread.start();
	}

}
