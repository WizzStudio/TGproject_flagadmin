package com.ctg.flagadmin.web.interceptor;

import com.ctg.flagadmin.enums.AdminKindEnum;
import com.ctg.flagadmin.exception.NoAuthorityException;
import com.ctg.flagadmin.utils.JWTUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SpaceApplyAuthorityInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws NoAuthorityException {
        // 预检，直接过
        if (request.getMethod().equalsIgnoreCase("OPTIONS")) return true;

        Integer role = (Integer) request.getAttribute(JWTUtil.USER_ROLE_KEY);
        if (role == null ||
                !role.equals(AdminKindEnum.FIRST_COUNCIL_ADMIN.getValue())) {
            throw new NoAuthorityException("You aren't council administration.");
        }
        return true;
    }
}
