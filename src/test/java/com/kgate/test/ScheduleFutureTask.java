package com.kgate.test;

import java.util.TimeZone;
import java.util.concurrent.ScheduledFuture;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.config.SchedulerBeanDefinitionParser;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ScheduleFutureTask {

	@Autowired
	TaskScheduler scheduler;

	private static int count = 0;

	@Test
	public void main(String[] args) throws InterruptedException {
		TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
//		String exp = " "+" "+" "+" ";
		String exp = "* * * * * ? *";
		CronTrigger trigger = new CronTrigger(exp, timeZone);
		Runnable task1 = () -> {
			count++;
			System.out.println("Running...task1 - count : " + count);
		};
		ScheduledFuture<?> scheduledFuture = scheduler.schedule(task1, trigger);

		while (true) {
			System.out.println("count :" + count);
			Thread.sleep(1000);
			if (count == 5) {
				System.out.println("Count is 5, cancel the scheduledFuture!");
				scheduledFuture.cancel(true);
				break;
			}
		}
	}
}
