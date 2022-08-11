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




//        Logger log = LoggerFactory.getLogger(AddingLog.class);
//        @Pointcut(value="execution(* us.rs.order.*.*.*(..))")
//        public void myPointcut(){
//        }
//
//        @Around("myPointcut()")
//        public Object applicationLog(ProceedingJoinPoint pjp)throws Throwable{
//            ObjectMapper mapper=new ObjectMapper();
//
//            String methodName=pjp.getSignature().getName();
//            String className=pjp.getTarget().getClass().toString();
//            Object[]array=pjp.getArgs();
//            log.info("method invoked"+className+":"+methodName+"()"+"arguments: "+mapper.writeValueAsString(array));
//            Object object=pjp.proceed();
//            log.info(className+":"+methodName+"()"+"Response:"
//                    +mapper.writeValueAsString(object));
//            return object;
//
//
//
//        }



    }

}
