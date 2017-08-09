package data.provider;

import com.alibaba.druid.util.StringUtils;
import data.model.data.object.BaseUserInfoDO;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by TY on 2017/7/26.
 */
public class UserInfoProvider {

    public static final  String TABLE_NAME = "t_user_base_info";

    private static final  String BASE_FIELD = "user_info_id,user_info_union_id,user_info_name,user_info_head_portraits,user_info_phone,user_info_is_delete,user_lock_version,user_update_time";

    /**
     * 通过token获取用户信息
     * @param token
     * @return
     */
    public String getUserInfoDOByTokenProvider(String token){

        String subSQL = new SQL().SELECT("ut_user_id").FROM("t_user_token").WHERE("ut_id = #{token}").toString();

        String sql = new SQL().SELECT(BASE_FIELD).FROM(TABLE_NAME).WHERE(String.format("user_info_id = (%s)",subSQL)).toString();

        return sql;
    }

    /**
     * 获取用户信息通过用户
     * @param userInfoDO
     * @return
     */
    public String getUserInfoDOProvider(BaseUserInfoDO userInfoDO){

        return new SQL(){{

            SELECT(BASE_FIELD);

            FROM(TABLE_NAME);

            if (!StringUtils.isEmpty(userInfoDO.getUser_info_union_id())){
                WHERE("user_info_union_id = #{user_info_union_id}");
            }

            if(!StringUtils.isEmpty(userInfoDO.getUser_info_phone())){
                WHERE("user_info_phone = #{user_info_phone}");

            }

        }}.toString();

    }

    public String insertUserInfoProvider(BaseUserInfoDO userInfoDO){

        String sql =  new SQL(){{

            INSERT_INTO(TABLE_NAME);

            VALUES("user_info_id","#{user_info_id,javaType=string,jdbcType=VARCHAR}");

            if (!StringUtils.isEmpty(userInfoDO.getUser_info_union_id())){
                VALUES("user_info_union_id","#{user_info_union_id,javaType=string,jdbcType=VARCHAR}");
            }

            if (!StringUtils.isEmpty(userInfoDO.getUser_info_name())){
                VALUES("user_info_name","#{user_info_name,javaType=string,jdbcType=VARCHAR}");
            }

            if (!StringUtils.isEmpty(userInfoDO.getUser_info_head_portraits())){
                VALUES("user_info_head_portraits","#{user_info_head_portraits,javaType=string,jdbcType=VARCHAR}");
            }

            if (!StringUtils.isEmpty(userInfoDO.getUser_info_phone())){
                VALUES("user_info_phone","#{user_info_phone,javaType=string,jdbcType=VARCHAR}");
            }

            if (userInfoDO.getUser_info_is_delete() != null){
                VALUES("user_info_is_delete","#{user_info_is_delete,javaType=string,jdbcType=VARCHAR}");
            }

        }}.toString();

        return sql;

    }

    public String updateUserInfoDOProvider(BaseUserInfoDO userInfoDO){

        String sql = new SQL(){{

            UPDATE(TABLE_NAME);

            if (!StringUtils.isEmpty(userInfoDO.getUser_info_name())){
                SET("user_info_name= #{user_info_name,javaType=string,jdbcType=VARCHAR}");
            }

            if (!StringUtils.isEmpty(userInfoDO.getUser_info_head_portraits())){
                SET("user_info_head_portraits = #{user_info_head_portraits,javaType=string,jdbcType=VARCHAR}");
            }

            if (userInfoDO.getUser_info_is_delete() != null){
                SET("user_info_is_delete = #{user_info_is_delete,javaType=string,jdbcType=VARCHAR}");
            }

            WHERE("user_info_id = #{user_info_id}");


        }}.toString();

        return sql;

    }

    public String duplicateUserInfoDOProvider(BaseUserInfoDO userInfoDO){

        String beforeSql = insertUserInfoProvider(userInfoDO)+" ON DUPLICATE KEY ";

        String afterSql = updateUserInfoDOProvider(userInfoDO);

        return beforeSql + afterSql;

    }

}
