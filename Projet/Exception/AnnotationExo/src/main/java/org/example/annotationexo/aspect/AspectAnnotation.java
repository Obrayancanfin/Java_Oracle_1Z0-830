package org.example.annotationexo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Aspect
public class AspectAnnotation {

    @Pointcut("@annotation(org.example.annotationexo.annotation.AroundAnnotation)")
    public void aroundPointCut() {
    }

    @Around("aroundPointCut()")
    public Object around (ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("aroundPointcut");
            Object[] args = joinPoint.getArgs();
            System.out.println(args);
            Object result = joinPoint.proceed(args);
            return result;
        }catch (Throwable e){
            throw new RuntimeException(e);
        }finally {
            return null;
        }
    }
}
