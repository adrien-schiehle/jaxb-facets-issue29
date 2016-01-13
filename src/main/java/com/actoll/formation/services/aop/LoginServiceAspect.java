package com.actoll.formation.services.aop;

import com.actoll.formation.services.Customer;
import com.actoll.formation.services.IdentificationService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 */
@Aspect
public class LoginServiceAspect {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Pointcut("within(com.actoll.formation.services.IdentificationService*)")
    public void serviceCall() {
    }

    @Pointcut("within(com.actoll.formation.services.IdentificationServiceWith*)")
    public void withPwdCall() {
    }

    @Pointcut("execution(public * getAllUsers(..))")
    public void callingGetAllUsers() {

    }


    @Before("serviceCall()")
    public void traceCalls( JoinPoint joinPoint ) {

        log.debug("Calling {}(..) with args {}",
                joinPoint.getSignature().getName(),
                joinPoint.getArgs());
    }

    @AfterReturning( pointcut = "withPwdCall() && callingGetAllUsers()",
                     returning = "list" )
    public void traceResults( JoinPoint joinPoint, List<Customer> list ) {

        log.info("Calling {}(..) returns {} users",
                joinPoint.getSignature().getName(),
                list.size());
    }
}
