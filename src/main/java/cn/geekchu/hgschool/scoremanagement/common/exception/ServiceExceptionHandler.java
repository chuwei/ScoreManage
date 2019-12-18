package cn.geekchu.hgschool.scoremanagement.common.exception;

import cn.geekchu.hgschool.scoremanagement.Result.ResponseResult;
import cn.geekchu.hgschool.scoremanagement.Result.ResultFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;

@RestControllerAdvice
public class ServiceExceptionHandler {

    @Resource
    private ObjectMapper jsonMapper;

    @ExceptionHandler(ServiceException.class)
    public ObjectNode serviceException(ServiceException e){
        int code = e.getCode();
        String msg = e.getMessage();
        return jsonMapper.createObjectNode().put("code",code).put("msg",msg);
    }

}