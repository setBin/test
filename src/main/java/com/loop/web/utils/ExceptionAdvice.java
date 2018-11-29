package com.loop.web.utils;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局异常处理器
 */
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {


    /**
     * Log4j日志处理(@author: rico)
     */
    private static final Logger log = Logger.getLogger(ExceptionAdvice.class);

//    /**
//     * 400 - Bad Request
//     */
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public Msg handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
////        logger.error("参数解析失败", e);
//        return Msg.success().add("msg", "could_not_read_json");
////        return new Response().failure("could_not_read_json");
//    }

    /**
     * 404 - Method Not Allowed
//     */
//    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public Msg handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
//
//        return Msg.success().add("msg", "could_not_read_json");
//
//    }

    /**
     * 404-NOT_FOUND
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public Msg handlerNotFoundException(NoHandlerFoundException e) {
        return Msg.success().add("msg", "not found");

    }
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Msg processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {
        return Msg.success().add("msg", "权限不足");
    }
//    @ExceptionHandler(Exception.class)
//    public Msg exceptionHandler(Exception e){
//        return Msg.fail().add("msg","系统异常");
//    }
//        捕获自定义异常
//  @ExceptionHandler(MessageException.class)
//   public Msg MessageException(Exception e) {
//
//       return Msg.success().add("msg", "自定义异常");
//   }
//   捕获全部的自定义异常
//    @ExceptionHandler(RuntimeException.class)
//    public Msg RuntimeException(Exception e) {
//
//        return Msg.success().add("msg", "运行异常");
//    }

        /**
         * 500 - Internal Server Error
         */


}