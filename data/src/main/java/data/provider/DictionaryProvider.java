package data.provider;

import com.alibaba.druid.util.StringUtils;
import data.model.data.object.DictionaryDO;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by TY on 2017/7/28.
 */
public class DictionaryProvider {

    public static final String TABLE_NAME = "t_dictionary";

    private static final String BASE_FIELD = "dict_id,dict_name,dict_type,dict_type";

    public String getDictionaryProvider(String id){

        return new SQL(){{

            SELECT(BASE_FIELD);

            FROM(TABLE_NAME);

            WHERE(" dict_id = #{id}");

        }}.toString();

    }

    public String listDictionaryProvider(DictionaryDO dictionaryDO){

        return new SQL(){{

            SELECT(BASE_FIELD);

            FROM(TABLE_NAME);

            if (!StringUtils.isEmpty(dictionaryDO.getDict_type())){
                WHERE("dict_type = #{dict_type}");
            }

            if (!StringUtils.isEmpty(dictionaryDO.getDict_condition())){
                WHERE("dict_condition = #{dict_condition}");
            }

        }}.toString();

    }

}
