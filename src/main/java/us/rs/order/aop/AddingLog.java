package us.rs.order.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Configuration
@Component
public class AddingLog {

    @Around("@annotation(us.rs.order.aop.Log)")
    public void createOrder(ProceedingJoinPoint joinPoint) throws Throwable{
        Object value=null;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method args values:");
        Arrays.stream(joinPoint.getArgs())
                .forEach(o -> System.out.println("arg value: " + o.toString()));
        joinPoint.proceed();
        value=joinPoint.proceed();
        System.out.println("Returning Order Data : "+value);

    }

}
