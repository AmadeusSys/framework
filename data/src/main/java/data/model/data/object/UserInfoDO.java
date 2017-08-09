
package data.model.data.object;


import data.common.BaseEntity;
import data.model.data.transfer.object.DD.DDUserDetailsDTO;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * 用户信息
 *
 * @author liuzh
 * @since 2016-01-31 21:39
 */
@Configuration
public class UserInfoDO extends BaseEntity {

    @ApiModelProperty(value = "user_info_id",example = "1")
    private String  user_info_id;

    @ApiModelProperty(value = "user_info_union_id",example = "manager5856")
    private String  user_info_union_id;

    @ApiModelProperty(value = "user_info_name",example = "佟阳")
    private String  user_info_name;

    @ApiModelProperty(value = "user_info_head_portraits",example = "http://static.dingtalk.com/media/lADOqqYgk80C7s0C7g_750_750.jpg")
    private String  user_info_head_portraits;

    @ApiModelProperty(value = "user_info_phone",example = "13066656961")
    private String  user_info_phone;

    @ApiModelProperty(value = "user_info_is_delete",example = "1")
    private Long  user_info_is_delete;

    @ApiModelProperty(value = "user_lock_version",example = "1")
    private String  user_lock_version;

    private Date user_update_time;

    static public UserInfoDO init(DDUserDetailsDTO ddUserDetailsDTO){

        UserInfoDO userInfoDO = new UserInfoDO();

        userInfoDO.setUser_info_union_id(ddUserDetailsDTO.getUserid());

        userInfoDO.setUser_info_name(ddUserDetailsDTO.getName());

        userInfoDO.setUser_info_head_portraits(ddUserDetailsDTO.getAvatar());

        userInfoDO.setUser_info_phone(ddUserDetailsDTO.getMobile());

        return userInfoDO;

    }

    public String getUser_info_id() {
        return user_info_id;
    }

    public void setUser_info_id(String user_info_id) {
        this.user_info_id = user_info_id;
    }

    public String getUser_info_union_id() {
        return user_info_union_id;
    }

    public void setUser_info_union_id(String user_info_union_id) {
        this.user_info_union_id = user_info_union_id;
    }

    public String getUser_info_name() {
        return user_info_name;
    }

    public void setUser_info_name(String user_info_name) {
        this.user_info_name = user_info_name;
    }

    public String getUser_info_head_portraits() {
        return user_info_head_portraits;
    }

    public void setUser_info_head_portraits(String user_info_head_portraits) {
        this.user_info_head_portraits = user_info_head_portraits;
    }

    public String getUser_info_phone() {
        return user_info_phone;
    }

    public void setUser_info_phone(String user_info_phone) {
        this.user_info_phone = user_info_phone;
    }

    public Long getUser_info_is_delete() {
        return user_info_is_delete;
    }

    public void setUser_info_is_delete(Long user_info_is_delete) {
        this.user_info_is_delete = user_info_is_delete;
    }

    public String getUser_lock_version() {
        return user_lock_version;
    }

    public void setUser_lock_version(String user_lock_version) {
        this.user_lock_version = user_lock_version;
    }

    public Date getUser_update_time() {
        return user_update_time;
    }

    public void setUser_update_time(Date user_update_time) {
        this.user_update_time = user_update_time;
    }

    public void reLoad(UserInfoDO userInfoDO){
        this.setUser_info_id(userInfoDO.getUser_info_id());
        this.setUser_info_union_id(userInfoDO.getUser_info_union_id());
        this.setUser_info_name(userInfoDO.getUser_info_name());
        this.setUser_info_head_portraits(userInfoDO.getUser_info_head_portraits());
        this.setUser_info_phone(userInfoDO.getUser_info_phone());
        this.setUser_info_is_delete(userInfoDO.getUser_info_is_delete());
        this.setUser_lock_version(userInfoDO.getUser_lock_version());
        this.setUser_update_time(userInfoDO.getUser_update_time());
    }

    @Override
    public String toString() {
        return "UserInfoDO{" +
                "user_info_id='" + user_info_id + '\'' +
                ", user_info_union_id='" + user_info_union_id + '\'' +
                ", user_info_name='" + user_info_name + '\'' +
                ", user_info_head_portraits='" + user_info_head_portraits + '\'' +
                ", user_info_phone='" + user_info_phone + '\'' +
                ", user_info_is_delete='" + user_info_is_delete + '\'' +
                ", user_lock_version='" + user_lock_version + '\'' +
                ", user_update_time=" + user_update_time +
                '}';
    }
}
