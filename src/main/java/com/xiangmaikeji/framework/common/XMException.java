package com.xiangmaikeji.framework.common;

/**
 * Created by TY on 2017/6/15.
 */
public class XMException extends  Exception {

    private int errorCode;

    public XMException(String errorMsg){
        super(errorMsg);
    }

    public XMException(String errorMsg, int errorCode){
        super(errorMsg);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
