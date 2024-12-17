package org.example.annotationexo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAnnotation {
    @Pointcut("@annotation(org.example.annotationexo.annotation.Exceptionannotation)")
    public void excepPointCut(){

    }

    @AfterThrowing(value = "excepPointCut()",throwing = "ex")
    public void afterThrowing (JoinPoint joinPoint, Exception ex){
        System.out.println("Exception message in Advice "+ex.getMessage()+ " "+ joinPoint.getSignature().getName());
    }
}
