package permission.service;


import component.tool.XMException;

/**
 * Created by TY on 2017/6/21.
 */
public class DDServiceException extends XMException {

    public DDServiceException(String errorMsg, int errorCode) {
        super(errorMsg, errorCode);
    }

}
