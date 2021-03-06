package com.hu.crm.web.interceptor;

import com.hu.crm.domain.Employee;
import com.hu.crm.util.UserContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserContext.set(request);
        Employee currentUser = (Employee) request.getSession().getAttribute(UserContext.USERINSESSION);
        if (currentUser == null) {
            response.sendRedirect("/login.jsp");
            return false;
        } else
            return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
