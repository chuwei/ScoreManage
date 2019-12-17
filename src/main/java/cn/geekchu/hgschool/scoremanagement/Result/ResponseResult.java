package cn.geekchu.hgschool.scoremanagement.Result;

import lombok.Data;

@Data
public class ResponseResult {
    //响应码
    private int code;
    private String message;
    private Object data;

    public ResponseResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
