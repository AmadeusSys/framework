package data.model.data.transfer.object.DD;

/**
 * Created by TY on 2017/6/21.
 */
public class DDBaseDTO {

    private Integer errcode;

    private String errmsg;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public boolean isOK(){
        return "ok".equals(errmsg) ? true : false;
    }

}
