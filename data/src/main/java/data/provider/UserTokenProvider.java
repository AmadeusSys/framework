package data.provider;

import data.model.UserTokenDO;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by TY on 2017/7/26.
 */
public class UserTokenProvider {

    public static final  String TABLE_NAME = "t_user_token";

    private static final  String BASE_FIELD = "ut_id,ut_user_id,ut_valid_time,ut_create_time,ut_update_time,ut_is_delete";

    public String addUserToken(UserTokenDO userTokenDO){

        return new SQL(){{

            INSERT_INTO(TABLE_NAME);

            VALUES("ut_id","#{ut_id}");
            VALUES("ut_user_id","#{ut_user_id}");
            VALUES("ut_create_time","#{ut_create_time}");
            VALUES("ut_valid_time","#{ut_valid_time}");
            VALUES("ut_update_time","#{ut_update_time}");
            VALUES("ut_is_delete","#{ut_is_delete}");

        }}.toString();

    }



}
