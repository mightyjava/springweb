package com.mightyjava.cron;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

public class ExecuteUsingAnnotation {
	//every 40 min
	@Scheduled(cron="0 0/40 * * * ?")
	public void run() {
		System.out.println("Execute using annotation in every 10 seconds " + new Date());
	}
}
