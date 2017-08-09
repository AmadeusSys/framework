package data.provider;

import data.model.BaseUserInfoDO;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * Created by TY on 2017/7/26.
 */
public class RuleProvider {

    public static final  String TABLE_NAME = "t_permission_rule";

    private static final  String BASE_FIELD = "rule_id,rule_name,rule_is_delete,rule_parent_id,rule_descritpion";

    public String getRuleByUserIdAndPath(Map condition){

        String sql = new SQL(){{

            SELECT(BASE_FIELD);

            FROM(TABLE_NAME);

            FROM("t_permission_group_rule");

            FROM("t_permission_group_user");

            WHERE("upper(rule_name) = #{path}");

            WHERE("gu_base_user_id = #{userId}");

            WHERE("t_permission_group_rule.gr_rule_id = t_permission_rule.rule_id");

            WHERE("t_permission_group_user.gu_group_id = t_permission_group_rule.gr_group_id");

        }}.toString();

        return sql;

    }

    /**
     * 获取权限列表
     * @param userId 用户id
     * @return
     */
    public String listRuleByUserIdProvider(String userId){

        String sql = new SQL(){{

            SELECT(BASE_FIELD).FROM("t_permission_group_user");

            LEFT_OUTER_JOIN(" t_permission_group_rule on t_permission_group_rule.gr_group_id = t_permission_group_user.gu_group_id");

            LEFT_OUTER_JOIN(" t_permission_rule on t_permission_rule.rule_id = t_permission_group_rule.gr_rule_id");

            WHERE("t_permission_group_user.gu_base_user_id = #{userId}");

        }}.toString();

        return sql;
    }



}
