//TimeCheckingInterceptor.java(10.04.2025)
package com.nt.interceptor;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TimeCheckingInterceptor implements HandlerInterceptor{
      
	@Override
	public boolean preHandle(HttpServletRequest req,HttpServletResponse res,Object handler) throws Exception{
		if(!req.getServletPath().equalsIgnoreCase("/")) {
			//Get System Date And Time
			LocalDateTime ldt=LocalDateTime.now();
			//Get Hour Of The Day
			int hour=ldt.getHour();
			if(hour<9 || hour>17) {
				RequestDispatcher rd=req.getRequestDispatcher("/timeout.jsp");
				rd.forward(req, res);
				return false;
			}
		}
		return true;
	}
}
