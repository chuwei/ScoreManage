package cn.geekchu.hgschool.scoremanagement.common.exception;

import cn.geekchu.hgschool.scoremanagement.common.constant.ServiceErrCode;

public class ServiceException extends RuntimeException{
        private int code;

        public ServiceException(String message, ServiceErrCode serviceErrCode) {//构造器的第二个参数是上面创建的那个枚举，之后把枚举里面定义的code给了这个code
            super(message);
            this.code = serviceErrCode.getCode();
        }

        public int getCode() {
            return code;
        }

        @Override
        public String getMessage() {
            return super.getMessage();
        }
}
