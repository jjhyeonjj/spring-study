package kr.co.work.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {
	@Around("execution(* kr.co.work.aop.MyMath.*(..))")
	public Object methodCallLog(ProceedingJoinPoint pjp) throws Throwable {
		
		long start = System.currentTimeMillis();
		System.out.println("<< [start]");
		
		Object result = pjp.proceed();					// target의 메서드 호출
		
		System.out.println((System.currentTimeMillis() - start) + "ms");
		System.out.println("result = "+ result);
		System.out.println("<< [end]");
		return result;
	}
}
