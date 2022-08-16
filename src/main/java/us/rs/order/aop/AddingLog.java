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

import java.util.Arrays;

@Aspect
@Configuration
@Component
public class AddingLog {

        Logger log = LoggerFactory.getLogger(AddingLog.class);
        @Pointcut(value="execution(* us.rs.order.*.*.*(..))")
        public void myPointcut(){
        }

        @Around("myPointcut()")
        public Object applicationLog(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
            ObjectMapper mapper=new ObjectMapper();

            String methodName=proceedingJoinPoint.getSignature().getName();
            String className=proceedingJoinPoint.getTarget().getClass().toString();
            Object[]array=proceedingJoinPoint.getArgs();
            log.info("method invoked"+className+":"+methodName+"()"+"arguments: "+mapper.writeValueAsString(array));
            Object object=proceedingJoinPoint.proceed();
            log.info(className+":"+methodName+"()"+"Response:" +mapper.writeValueAsString(object));
            return object;



        }



    }


