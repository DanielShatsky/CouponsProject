package com.daniel.coupons.exceptions;

import com.daniel.coupons.beans.ErrorBean;
import com.daniel.coupons.enums.ErrorType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseBody
    public ErrorBean handleException(Throwable throwable, HttpServletResponse response) {

        if(throwable instanceof ApplicationException) {

            ApplicationException applicationException = (ApplicationException) throwable;

            ErrorType errorType = applicationException.getErrorType();
            int errorId = errorType.getErrorId();
            String errorMessage = errorType.getErrorMessage();
            response.setStatus(errorId);


            ErrorBean errorBean = new ErrorBean(errorId ,errorMessage);
            if(applicationException.getErrorType().isPrintStackTrace()) {
                applicationException.printStackTrace();
            }

            return errorBean;
        }

        response.setStatus(600);

        ErrorBean errorBean = new ErrorBean(601, "General error");
        throwable.printStackTrace();

        return errorBean;
    }

}
