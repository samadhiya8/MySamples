package com.mycompany.hibernateinspring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggerAspect {

	/**
	 * @param args
	 */
	@Pointcut("execution(* com.mycompany.hibernateinspring.*.*(..))")
	public void applyLog(){
		
	}
	@Before("applyLog()")
	public void beforeLog(){
		System.out.println("Before time is: "+System.currentTimeMillis());
	}
	@AfterReturning("applyLog()")
	public void afterLog(){
		System.out.println("After log is: "+System.currentTimeMillis());
	}
}
