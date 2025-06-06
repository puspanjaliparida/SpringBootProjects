//JobMonitoringListener.java(01.06.2025)
package com.nt.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobMonitoringListener implements JobExecutionListener {
     private Long start,end;
     
	@Override
	public void beforeJob(JobExecution jobExecution) {
          start=System.currentTimeMillis();
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		  end=System.currentTimeMillis();
		  System.out.println("Job Exceution Duration:: "+(end-start));
		  System.out.println("Job Exceution Status:: "+jobExecution.getExitStatus());
	}
}
