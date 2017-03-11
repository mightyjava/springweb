package com.mightyjava.batch;

import java.util.Map;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.mightyjava.service.UserService;

public class ExecuteTasklet implements Tasklet {
	
	@Autowired
	private UserService userService;
	
	private Map<Object, String> params;

	public Map<Object, String> getParams() {
		return params;
	}

	public void setParams(Map<Object, String> params) {
		this.params = params;
	}

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		Map<?, ?> jobParameters = chunkContext.getStepContext().getJobParameters();
		params.clear();
		for (Map.Entry<?, ?> entry : jobParameters.entrySet()) {
			params.put(entry.getKey(), entry.getValue().toString());
		}
		System.out.println("Running Job - " + params);
		System.out.println(userService.userList());
		return RepeatStatus.FINISHED;
	}

}
