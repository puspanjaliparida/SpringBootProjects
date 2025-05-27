//ReportGenerationService.java(12/13.04.2025)
package com.nt.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ReportGenerationService {
    
	/*@Scheduled(initialDelay = 10000,fixedDelay = 3000)
	public void showReport() {
		System.out.println("Report On::"+new Date());
	}*/
	
	/*@Scheduled(fixedDelay = 7000)
	public void showReport1() {
		System.out.println("Report1 On::"+new Date());
	}*/
	
	/*@Scheduled(fixedDelayString = "3000")
	public void showReport1() {
		System.out.println("Report1 On::"+new Date()+"Thread name::"+Thread.currentThread().getName());
	}
	
	@Scheduled(fixedDelay = 7000)
	public void showReport2() {
		System.out.println("Report2(Started)::"+new Date()+Thread.currentThread().getName());
		try {
			Thread.sleep(10000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Report2(Ended)::"+new Date());
	}*/
	
	/*@Scheduled(fixedRate = 10000)
	public void showReport2() {
		System.out.println("Report2(Started)::"+new Date()+Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Report2(Ended)::"+new Date());
	}*/
	/*6 stars* are there
	 * second,minute,hour,day,month,weekday*/
	    
	//Every minute at second 20
	//@Scheduled(cron="20 * * * * *")
	//Every hour at minute 10
	//@Scheduled(cron="0 10 * * * *")
	//Every month 1st day at 10
	//@Scheduled(cron="0 0 10 1 *  *")
	//august 15 at 10
	//@Scheduled(cron="0 0 10 15 8 *")
	//October 20 at 07.30
	//@Scheduled(cron="0 30 7 20 10 *")
	//at 9 and 12 hours
	//@Scheduled(cron="0 0 9,12 * * *")
	//At 12 minute every hour between 9 and 12
	//@Scheduled(cron="0 12 9-12 * * *")
	//at 10.00 at 1 day at january month at sunday
	//@Scheduled(cron="0 0 10 1 1 0")
	//At 17.00 every day between every day between thur to sat
	//@Scheduled(cron="0 0 17 * * THU-SAT")
	//every minute at 18 hour
	//@Scheduled(cron="0 * 18 * * *")
	//at 10.00 at tuesday
	//@Scheduled(cron="0  0 10 ? * TUE")
	/*public void showReport2() {
		System.out.println("Report Generated On::"+new Date());	
	}*/
	//Every 10 seconds
	//@Scheduled(cron="0/10 * * * * *")
	//every 2 minutes at 10 hour
	//@Scheduled(cron="0 0/2 10 * * *")
	//At 10.00 every 3 days
	//@Scheduled(cron="0 0 10 1/3 * *")
	//at 10.00 at 29 day at February month
	//@Scheduled(cron="0 0 10 29 2 ?")
	//every 30 seconds every 20 minutes
	//@Scheduled(cron="0/30 1/20 * * * *")
	//every second
	//@Scheduled(cron="* * * *  * *")
	//at 19.00 every 3 months(here 1 is start and 3 is gap)
	//@Scheduled(cron="0 0 19 ? 1/3 ?")
	//@Scheduled(cron="@hourly")
	//at 8.49 2nd sunday of every month
	@Scheduled(cron="0 49 8 * * SUN#2")
	public void showReport2() {
		System.out.println("Report Generated On::"+new Date());	
	}
}
