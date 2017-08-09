package data.model.data.transfer.object.DD;

/**
 * Created by TY on 2017/6/21.
 */
public class DDUserDTO extends DDBaseDTO {
    private String    userid;
    private String    deviceId;
    private boolean   is_sys;
    //级别，0：非管理员 1：超级管理员（主管理员） 2：普通管理员（子管理员） 100：老板
    private int       sys_level;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public boolean isIs_sys() {
        return is_sys;
    }

    public void setIs_sys(boolean is_sys) {
        this.is_sys = is_sys;
    }

    public int getSys_level() {
        return sys_level;
    }

    public void setSys_level(int sys_level) {
        this.sys_level = sys_level;
    }
}
