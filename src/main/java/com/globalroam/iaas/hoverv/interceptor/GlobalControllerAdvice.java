package com.globalroam.iaas.hoverv.interceptor;

import com.globalroam.iaas.hoverv.exception.FormInputInvalidException;
import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * the central place to setup data validator for controller and
 * global exception handler
 * Created by chenglong on 2015/10/20.
 */
@ControllerAdvice
public class GlobalControllerAdvice {
    /**
     * log4j logger for logging
     */
    private final Logger logger = Logger.getLogger(GlobalControllerAdvice.class);
    /**
     * the suffix of validator implementation,
     * the default validator name should be like:
     * LoginFormValidator,the formula is:form name plus Validator suffix
     */
    private final String suffix = "Validator";
    /**
     * the domain field position in the error code ,
     * the default error formula is:formName.className.fieldName.errorType
     * e.g.loginForm.user.username.empty means user name is empty
     */
    private static final int FIELD_NAME_POSITION = 2;
    /**
     * the default separator to segment error code,default use period.
     */
    private static final String errorCodeSeparator = "\\.";

    /**
     * configure the validator for controller method,please ensure that
     * form data transfer object and validator stay with in the same folder,or
     * a class not found exception will be thrown.
     *
     * @param binder the web data binder for setup validator
     */
    @InitBinder
    public void globalInitBinder(WebDataBinder binder) {
        Object target = binder.getTarget();
        if (target == null) {
            logger.debug("no target need to bind validator");
            return;
        }
        String formName = target.getClass().getName();
        String validatorName = formName + suffix;
        try {
            Validator validator = (Validator) Class.forName(validatorName).newInstance();
            binder.setValidator(validator);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("the validator class cannot find.");
        } catch (InstantiationException e) {
            throw new RuntimeException("cannot instantiate the validator,please check if there is a proper constructor");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("cannot access the validator because no permission.");
        }
    }

    /**
     * this handler method will capture any un resolved exception during the calling of
     * controller method,and will transfer the exception message to json format error message
     * then send to the end user for any kind of hint.
     *
     * @param ex      the exception captured in progress of calling controller
     * @param request the http servlet request
     * @return json format error message
     */
    @ExceptionHandler
    @ResponseBody
    public Object exceptionHandler(Exception ex, HttpServletRequest request) {
        Errors errors = ((FormInputInvalidException) ex).getErrors();
        RequestContext requestContext = new RequestContext(request);
        Map<String, String> errorMessages = new HashMap<String, String>();
        for (ObjectError fieldError : errors.getAllErrors()) {
            String errorCode = fieldError.getCode();
            String errorMessage = requestContext.getMessage(errorCode);
            errorMessages.put(parseFieldName(errorCode), errorMessage);
        }
        return errorMessages;
    }

    /**
     * parse the field name of domain property from error code
     *
     * @param errorCode the error code set up in validator implementation
     * @return the domain object's field name,if the error code is malformed it will
     * return the error code itself as fallback
     */
    private String parseFieldName(String errorCode) {
        String[] names = errorCode.split(errorCodeSeparator);
        if (names.length < 3) {
            logger.debug("malformed errorCode==>" + errorCode + " the result filed name will use the error code as name .");
            return errorCode;
        }
        return names[FIELD_NAME_POSITION];
    }
}
