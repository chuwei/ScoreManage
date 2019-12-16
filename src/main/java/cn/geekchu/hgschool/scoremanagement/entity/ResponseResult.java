package cn.geekchu.hgschool.scoremanagement.entity;

import lombok.Data;

@Data
public class ResponseResult {
    //响应码
    private int code;
    private String message;

    public ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
