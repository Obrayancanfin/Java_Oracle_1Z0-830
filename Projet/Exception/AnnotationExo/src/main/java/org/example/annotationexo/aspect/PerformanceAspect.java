package org.example.annotationexo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.example.annotationexo.annotation.AroundAnnotation;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class PerformanceAspect {
    @Pointcut("@annotation(org.example.annotationexo.annotation.PerformanceAnnotation)")
    public void aroundPointCut() {
    }

    @Around("aroundPointCut()")
    public void aroundAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis() ;

        Object[] args = joinPoint.getArgs();
        System.out.println(args);
        Object result = joinPoint.proceed(args);

        try {
            System.out.println("After Book is created");
        }catch (Throwable e){
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis() - start ;
        System.out.println("method during "+end+" ms");
    }
}
