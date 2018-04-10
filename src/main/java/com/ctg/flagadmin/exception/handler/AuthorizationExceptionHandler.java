package com.ctg.flagadmin.exception.handler;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.ctg.flagadmin.exception.NoJWTException;
import com.ctg.flagadmin.pojo.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class AuthorizationExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(AuthorizationExceptionHandler.class);

    @ExceptionHandler(value = {NoJWTException.class, SignatureVerificationException.class})
    @ResponseBody
    public ResponseDto authorizationErrorHandler(HttpServletResponse response, Exception e) {
        // 获取异常栈
        StackTraceElement[] stackTrace = e.getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append(e.fillInStackTrace()).append("\n");

        for (StackTraceElement element : stackTrace) {
            sb.append("\tat ").append(element).append("\n");
        }

        // 记录日志
        logger.error(sb.toString());

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        return ResponseDto.failed("authenticated unsuccessfully");
    }
}
