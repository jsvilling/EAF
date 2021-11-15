package ch.fhnw.eaf.rental.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

// @Component
// @Aspect
public class SecurityInterceptor {
    private Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);

    @Value("${movierental.security.token}")
    private String securityToken;

    @Around("within(*..controllers..*)")
    public Object checkRequestParameter(ProceedingJoinPoint pjp) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = request.getParameter("token");
        logger.debug("token is '{}'", token);
        if ((token != null) && (token.equals(securityToken))) {
            return pjp.proceed();            
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
