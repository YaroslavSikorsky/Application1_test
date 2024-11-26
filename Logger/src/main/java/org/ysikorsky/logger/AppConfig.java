package org.ysikorsky.logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

	@Bean
	public LoggerThread provideSomeLoggerThread() {
		LoggerThread loggerThread = new LoggerThread();
		System.out.println("loggerThread state: " + loggerThread.getState() + ", loggerThread name: " + loggerThread.getName());
		return loggerThread;
	}


}
