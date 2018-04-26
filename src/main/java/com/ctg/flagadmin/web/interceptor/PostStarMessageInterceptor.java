package com.ctg.flagadmin.web.interceptor;

import com.ctg.flagadmin.enums.AdminKindEnum;
import com.ctg.flagadmin.exception.NoAuthorityException;
import com.ctg.flagadmin.utils.JWTUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class PostStarMessageInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws NoAuthorityException {
        Integer role = (Integer) request.getAttribute(JWTUtil.USER_ROLE_KEY);

        // 预检，若含有authorization，直接过
        if (request.getMethod().equalsIgnoreCase("OPTIONS") &&
                request.getHeader("access-control-request-headers").equalsIgnoreCase(JWTUtil.JWT_HTTP_HEADER)) {
            return true;
        }

        if (role == null || !role.equals(AdminKindEnum.FIRST_COUNCIL_ADMIN.getValue())) {
            throw new NoAuthorityException();
        }

        return true;
    }
}
