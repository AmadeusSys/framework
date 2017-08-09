package data.provider;

import com.alibaba.druid.util.StringUtils;

import data.model.data.object.ContractDo;
import org.apache.ibatis.jdbc.SQL;


/**
 * Created by TY on 2017/7/26.
 */
public class ContractProvider {

    public static final  String TABLE_NAME = "t_logic_contract";

    private static final  String BASE_FIELD = "contract_id,contract_create_time,contract_content,contract_create_user_id,contract_update_time,contract_name";

    public String getContractProvider(String id){

        return new SQL().SELECT(BASE_FIELD).FROM(TABLE_NAME).WHERE("contract_id=#{id}").toString();

    }

    public String addContractProvider(ContractDo contractDo){

        return new SQL(){{

            INSERT_INTO(TABLE_NAME);

            VALUES("contract_id","#{contract_id}");

            if (!StringUtils.isEmpty(contractDo.getContract_name())){
                VALUES("contract_name","#{contract_name}");
            }

            if (contractDo.getContract_create_time() != null){
                VALUES("contract_create_time","#{contract_create_time}");
            }

            if (!StringUtils.isEmpty(contractDo.getContract_content())){
                VALUES("contract_content","#{contract_content}");
            }

            if (!StringUtils.isEmpty(contractDo.getContract_create_user_id())){
                VALUES("contract_create_user_id","#{contract_create_user_id}");
            }

        }}.toString();

    }

    public String saveContractProvider(ContractDo contractDo){

        return new SQL(){{

            UPDATE(TABLE_NAME);

            if (!StringUtils.isEmpty(contractDo.getContract_name())){

                SET("contract_name = #{contract_name}");

            }

            if (!StringUtils.isEmpty(contractDo.getContract_content())){
                SET("contract_content = #{contract_content}");
            }

            WHERE("contract_id = #{contract_id}");


        }}.toString();

    }

    public String listContractProvider(ContractDo contractDo){

        return new SQL() {{

            SELECT(BASE_FIELD);

            FROM(TABLE_NAME);

            WHERE("contract_is_delete = 0");

            if (!StringUtils.isEmpty(contractDo.getSearchPassWord())){

                WHERE("contract_name LIKE '%#{searchPassWord}%' ");

            }


        }}.toString();

    }

    public String totalNumberProvider(){
        return new SQL().SELECT("count(contract_id)").FROM(TABLE_NAME).toString();
    }

}
