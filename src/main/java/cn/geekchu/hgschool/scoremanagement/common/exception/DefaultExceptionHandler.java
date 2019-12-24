package cn.geekchu.hgschool.scoremanagement.common.exception;

import cn.geekchu.hgschool.scoremanagement.result.ResponseResult;
import cn.geekchu.hgschool.scoremanagement.result.ResultFactory;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult handleAuthorizationException(UnauthorizedException e) {
        String message = "您无权查看该信息，请与管理员联系";
        return ResultFactory.buildFailResult(message);
    }
}
