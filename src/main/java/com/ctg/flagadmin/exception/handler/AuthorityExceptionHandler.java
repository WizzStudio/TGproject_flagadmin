package com.ctg.flagadmin.exception.handler;

import com.ctg.flagadmin.exception.NoAuthorityException;
import com.ctg.flagadmin.pojo.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class AuthorityExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(AuthorityExceptionHandler.class);

    @ExceptionHandler(value = NoAuthorityException.class)
    @ResponseBody
    public ResponseDto authorityErrorHandler(HttpServletResponse response, Exception e) {
        // 获取异常栈
        StackTraceElement[] stackTrace = e.getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append(e.fillInStackTrace()).append("\n");

        for (StackTraceElement element : stackTrace) {
            sb.append("\tat ").append(element).append("\n");
        }

        // 记录日志
        logger.error(sb.toString());

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        return ResponseDto.failed("Insufficient permissions");
    }
}
