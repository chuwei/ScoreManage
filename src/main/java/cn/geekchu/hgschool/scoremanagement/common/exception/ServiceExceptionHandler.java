package cn.geekchu.hgschool.scoremanagement.common.exception;

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