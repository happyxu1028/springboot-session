package com.xubin.learn.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求的URL
        String url = request.getRequestURI();
        // URL:除了登录请求外，其他的URL都进行拦截控制
        if ("/".equals(url)||url.indexOf("/login") >= 0) {
            return true;
        }
        Object user = request.getSession().getAttribute("user");
        if(user==null){
//            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);//地址不变
            response.sendRedirect("/login");//地址栏要变
            //以上两种方式都可以
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
