package com.mightyjava.controller;

import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/job")
public class JobLauncherController {
	private static final String TIME = "time";
	private static final String JOB_PARAM = "job";

	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private JobRegistry jobRegistry;

	@RequestMapping("/launch/{taskName}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void launchJob(@PathVariable String taskName) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException, NoSuchJobException {
		System.out.println("Task Name : " + taskName); 
		JobParametersBuilder builder = new JobParametersBuilder();
		builder.addLong(TIME, System.currentTimeMillis()).toJobParameters();
		builder.addString(JOB_PARAM, taskName);
		jobLauncher.run(jobRegistry.getJob(taskName), builder.toJobParameters());
	}

}
