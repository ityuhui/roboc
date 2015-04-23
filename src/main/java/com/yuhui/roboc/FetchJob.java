package com.yuhui.roboc;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class FetchJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//FetchUtil.printSto("SZ002340");
		FetchUtil.printSto("SH600660");
	}
}
