package cn.geekchu.hgschool.scoremanagement.Result;

import cn.geekchu.hgschool.scoremanagement.Result.ResponseResult;

public class ResultFactory {

    public static ResponseResult buildSuccessResult(Object data) {
        return buildResult(ResultCode.SUCCESS, "成功", data);
    }

    public static ResponseResult buildFailResult(String message) {
        return buildResult(ResultCode.FAIL, message, null);
    }

    public static ResponseResult buildResult(ResultCode resultCode, String message, Object data) {
        return buildResult(resultCode.code, message, data);
    }

    public static ResponseResult buildResult(int resultCode, String message, Object data) {
        return new ResponseResult(resultCode, message, data);
    }
}