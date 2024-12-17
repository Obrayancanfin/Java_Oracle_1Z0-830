package org.example.annotationexo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AfterMethod {

    @Pointcut("@annotation(org.example.annotationexo.annotation.AfterCreateAnnotation)")
    public void aroundPointCut() {
    }

    @After(value = "aroundPointCut()")
    public void after() {
        try {
            System.out.println("After method is invoked");
        }catch (Throwable e){
            throw new RuntimeException(e);
        }
    }
}
