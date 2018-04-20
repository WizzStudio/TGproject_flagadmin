package com.ctg.flagadmin.web.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ctg.flagadmin.exception.NoJWTException;
import com.ctg.flagadmin.utils.JWTUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws NoJWTException {
        String token = JWTUtil.getToken(request);

        // 预检，若含有authorization，直接过
        if (request.getMethod().equalsIgnoreCase("OPTIONS") &&
                request.getHeader("access-control-request-headers").equalsIgnoreCase(JWTUtil.JWT_HTTP_HEADER)) {
            return true;
        }

        if (token == null) {
            throw new NoJWTException();
        }

        DecodedJWT decodedJWT = JWTUtil.verifyToken(token);
        Integer userId = decodedJWT.getClaim(JWTUtil.USER_ID_KEY).asInt();
        Integer userRole = decodedJWT.getClaim(JWTUtil.USER_ROLE_KEY).asInt();

        request.setAttribute(JWTUtil.USER_ID_KEY, userId);
        request.setAttribute(JWTUtil.USER_ROLE_KEY, userRole);

        return true;
    }
}
