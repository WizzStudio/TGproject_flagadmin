package com.ctg.flagadmin.web.interceptor;

import com.ctg.flagadmin.enums.AdminKindEnum;
import com.ctg.flagadmin.exception.NoAuthorityException;
import com.ctg.flagadmin.utils.JWTUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Component
public class PostMessageInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws NoAuthorityException,UnsupportedEncodingException {
        //乱码问题
        request.setCharacterEncoding("utf-8");
        Integer role = (Integer) request.getAttribute(JWTUtil.USER_ROLE_KEY);

        // 预检，直接过
        if (request.getMethod().equalsIgnoreCase("OPTIONS")) return true;

        if (role == null || !role.equals(AdminKindEnum.FIRST_COUNCIL_ADMIN.getValue())) {
            throw new NoAuthorityException("No Authority to Post Message.");
        }

        return true;
    }
}
