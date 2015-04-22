package com.yuhui.roboc;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

public class MainApp {

	public static void main(String[] args) {

		try {
			// Grab the Scheduler instance from the Factory
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

			// and start it off
			scheduler.start();
			
			// define the job and tie it to our HelloJob class
			JobDetail job = newJob(FetchJob.class)
			    .withIdentity("job1", "group1")
			    .build();

			// Trigger the job to run now, and then repeat every 40 seconds
			Trigger trigger = newTrigger()
			    .withIdentity("trigger1", "group1")
			    .startNow()
			    .withSchedule(simpleSchedule()
			            .withIntervalInSeconds(5)
			            .repeatForever())
			    .build();

			// Tell quartz to schedule the job using our trigger
			scheduler.scheduleJob(job, trigger);
			
			Thread.sleep(60000);
			scheduler.shutdown();

		} catch (SchedulerException se) {
			se.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
