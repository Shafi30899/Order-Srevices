package us.rs.order.aop;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import us.rs.order.repository.OrderRepository;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;

@Aspect
@Configuration
@Component
public class LogImplementation {

 //   Logger logger = LoggerFactory.getLogger(this.getClass());
//    Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());
    @Pointcut(value="execution(* us.rs.order.*.*.*(..))")
// @Pointcut(value="execution(* us.rs.order.repository.OrderRepository")
    public void myPointcut(){
    }

    @Around("myPointcut()")
    public Object applicationLog(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        Logger logger=LoggerFactory.getLogger(proceedingJoinPoint.getTarget().getClass().getCanonicalName());
        ObjectMapper mapper=new ObjectMapper();

        String methodName=proceedingJoinPoint.getSignature().getName();
        String className=proceedingJoinPoint.getTarget().getClass().toString();
        Object[]array=proceedingJoinPoint.getArgs();
        logger.info("method invoked"+className+":"+methodName+"()"+"arguments: "+mapper.writeValueAsString(array));
        Object object=proceedingJoinPoint.proceed();
        logger.info(className+":"+methodName+"()"+"Response:" +mapper.writeValueAsString(object));
        return object;



    }



}



