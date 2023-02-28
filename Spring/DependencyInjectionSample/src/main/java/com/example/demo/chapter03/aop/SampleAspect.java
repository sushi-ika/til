package com.example.demo.chapter03.aop;

import java.text.SimpleDateFormat;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleAspect {
	@Before("execution(* com.example.demo.chapter03.used.*Greet.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("====Before Advice====");
		System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date()));
		System.out.println(String.format("メソッド:%s", joinPoint.getSignature().getName()));
	}
}
