package com.globalroam.iaas.hoverv.aop;

import com.globalroam.iaas.hoverv.exception.FormInputInvalidException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 * to check if there is some error within the error object,
 * if there are something wrong a form input invalid exception
 * will be thrown to indicates that the user input is not qualified
 * for the application.
 * Created by chenglong on 2015/10/20.
 */
@Component
@Aspect
public class FormValidationAop {
    /**
     * an aop method to do the final check with the error object,
     * if there are some errors exist,a form input invalid exception
     * will be thrown.
     *
     * @param joinPoint the join point for the target method call
     *                  ,some useful information such as method arguments
     *                  of target method can obtain from this object.
     */
    @Before("execution(* com.globalroam.iaas.hoverv.controller..*(..))")
    public void validate(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (Errors.class.isAssignableFrom(arg.getClass())) {
                Errors errors = (Errors) arg;
                if (errors.hasErrors()) {
                    throw new FormInputInvalidException(errors);
                }
            }
        }
    }
}
