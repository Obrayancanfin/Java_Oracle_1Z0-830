package org.example.annotationexo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;

public class AnnotationAspectAdvice {
    @Before("execution(* org.example.annotationexo.service.*.*(..))")
    public void before(){
        System.out.println("Before Method");
    }

    @After("execution(* org.example.annotationexo.service.*.*(..))")
    public void after(){
        System.out.println("After Method");
    }

    @AfterReturning(value="execution(* org.example.annotationexo.service.AnnotationService.methodWithResult(..))",returning = "result")
    public void afterReturning(String result){
        System.out.println("After Returning Method and result is "+result);
    }
}

