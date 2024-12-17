package org.example.annotationexo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeMethod {
    @Pointcut("@annotation(org.example.annotationexo.annotation.BeforeCreateAnnotation)")
    public void aroundPointCut() {
    }

    @Before(value = "aroundPointCut()")
    public void before(JoinPoint joinPoint) {
        try {
            System.out.println("Before method invoked");
            Object[] args = joinPoint.getArgs();
            System.out.println(args);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
