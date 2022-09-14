package us.rs.order.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AddingLoggerExecutionTime {

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Around("@annotation(us.rs.order.aop.LoggerExecutionTime)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime=System.currentTimeMillis();

        Object proceed=joinPoint.proceed();

        long executionTime=System.currentTimeMillis()-startTime;

        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;



    }
}
