package com.xiangmaikeji.framework.model;

import com.xiangmaikeji.framework.mapper.provider.UserTokenProvider;

import javax.persistence.Table;
import java.util.Date;

@Table(name = UserTokenProvider.TABLE_NAME)
public class UserTokenDO {

    private String ut_id;
    private String ut_user_id;
    private String ut_devices_tag;
    private Integer ut_valid_time;
    private Date ut_create_time;
    private Date ut_update_time;
    private Boolean ut_is_delete;

    public String getUt_id() {
        return ut_id;
    }

    public void setUt_id(String ut_id) {
        this.ut_id = ut_id;
    }

    public String getUt_user_id() {
        return ut_user_id;
    }

    public void setUt_user_id(String ut_user_id) {
        this.ut_user_id = ut_user_id;
    }

    public String getUt_devices_tag() {
        return ut_devices_tag;
    }

    public void setUt_devices_tag(String ut_devices_tag) {
        this.ut_devices_tag = ut_devices_tag;
    }

    public Integer getUt_valid_time() {
        return ut_valid_time;
    }

    public void setUt_valid_time(Integer ut_valid_time) {
        this.ut_valid_time = ut_valid_time;
    }

    public Date getUt_create_time() {
        return ut_create_time;
    }

    public void setUt_create_time(Date ut_create_time) {
        this.ut_create_time = ut_create_time;
    }

    public Date getUt_update_time() {
        return ut_update_time;
    }

    public void setUt_update_time(Date ut_update_time) {
        this.ut_update_time = ut_update_time;
    }

    public Boolean getUt_is_delete() {
        return ut_is_delete;
    }

    public void setUt_is_delete(Boolean ut_is_delete) {
        this.ut_is_delete = ut_is_delete;
    }

    public static UserTokenDO init(String userId){

        UserTokenDO userTokenDO = new UserTokenDO();

        userTokenDO.setUt_user_id(userId);

        userTokenDO.setUt_create_time(new Date());

        userTokenDO.setUt_valid_time(7200);

        userTokenDO.setUt_update_time(new Date());

        userTokenDO.setUt_is_delete(false);

        return userTokenDO;

    }
}
