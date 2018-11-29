package com.loop.web.utils;

import com.loop.web.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录拦截器
public class BaseInterceptor  implements HandlerInterceptor {


    @Autowired
    LogService logService;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        //获取请求的URL
//        HttpSession session = httpServletRequest.getSession();
//        UserInfo user = JWT.unsign(token, UserInfo.class);
//        if (user != null) {
//            return true;
//        }
        //获取请求地址
        System.out.println(httpServletRequest.getMethod()+" "+httpServletRequest.getRequestURI());
        System.out.println(CommonHelper.getIpAddr(httpServletRequest));
        System.out.println(CommonHelper.getIpAddr1(httpServletRequest));
        System.out.println(httpServletRequest.getHeader("User-Agent"));
        logService.addLog(httpServletRequest);
//        HttpSession httpSession=httpServletRequest.getSession();
//        Object  object=httpSession.getAttribute("user");
//        if(object!=null)
//        {
//            httpServletResponse.setStatus(200);
//            return true;
//        }
//        httpServletResponse.setStatus(403);
//        httpServletResponse.sendRedirect("http://localhost:8080/web/login/error");
//        return false;


//
//
            return true;
//
//        }
////        //获取Session

////
////        if(username != null){
////            return true;
////
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
