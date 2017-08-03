package com.xiangmaikeji.framework.common;

public class ResponseData {
    private Long statusCode;
    private Object data;
    private Long errorCode;
    private String errorMsg;
    private Long timeStamp = System.currentTimeMillis()/1000;
    public static ResponseData initSuccess(Object data){
        ResponseData responseData = new ResponseData();
        responseData.statusCode = Long.valueOf(200);
        responseData.data = data;
        return responseData;
    }

    public static ResponseData initError(String errorMsg,Long errorCode) {
        return ResponseData.initError(400L,errorMsg,errorCode);
    }

    public static ResponseData initError(Long statusCode,String errorMsg,Long errorCode){
        ResponseData responseData = new ResponseData();
        responseData.statusCode = statusCode;
        responseData.errorCode = errorCode;
        responseData.errorMsg = errorMsg;
        return responseData;
    }

    public Long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Long statusCode) {
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
