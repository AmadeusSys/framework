/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package data.model.data.object;



import data.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Collection;
import java.util.Date;

/**
 * 用户信息
 *
 * @author liuzh
 * @since 2016-01-31 21:39
 */
@Table(name = "t_user_base_info")
public class BaseUserInfoDO extends BaseEntity {

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
    private Boolean  user_info_is_delete;

    @ApiModelProperty(value = "user_lock_version",example = "1")
    private String  user_lock_version;

    private Date user_update_time;

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

    public Boolean getUser_info_is_delete() {
        return user_info_is_delete;
    }

    public void setUser_info_is_delete(Boolean user_info_is_delete) {
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
