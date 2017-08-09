package data.model.data.transfer.object;

/**
 * Created by TY on 2017/6/15.
 */
public class LoginDTO {

    private String msg;

    private Boolean status;

    private LoginBodyDTO value;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LoginBodyDTO getValue() {
        return value;
    }

    public void setValue(LoginBodyDTO value) {
        this.value = value;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

