package io.deeti.aroundadvice.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CacheAspect {
	
	private static final Logger logger = Logger.getLogger("CacheAspect");
	
	HashMap<String, Object> cache = new HashMap<>();
	
	@Around("execution(* io.deeti.aroundadvice.aspect.service.*.*(..))")
	public Object caching(ProceedingJoinPoint joinPoint) throws Throwable {
		
		
		String key = joinPoint.getSignature() + Arrays.toString(joinPoint.getArgs());
		
		if(!cache.containsKey(key)) {
			
			Object retValue = joinPoint.proceed();
			
			cache.put(key, retValue);
			
			logger.exiting("CacheAspect", "caching");
			
			return retValue;
		} else {
			
			return cache.get(key);
		}
		
	}

}
