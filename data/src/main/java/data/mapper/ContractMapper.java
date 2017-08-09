package data.mapper;


import data.model.data.object.ContractDo;
import data.provider.ContractProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

public interface ContractMapper {

    @SelectProvider(type = ContractProvider.class,method = "listContractProvider")
    List<ContractDo> listContract(ContractDo contractDo);

    @SelectProvider(type = ContractProvider.class,method = "getContractProvider")
    ContractDo getContract(String id);

    @UpdateProvider(type = ContractProvider.class,method = "saveContractProvider")
    Long saveContract(ContractDo contractDo);

    @InsertProvider(type = ContractProvider.class,method = "addContractProvider")
    @SelectKey(statement="select replace(uuid(),'-','') from dual", keyProperty="contract_id", before=true, resultType=String.class)
    Long addContract(ContractDo contractDo);

    @SelectProvider(type = ContractProvider.class,method = "totalNumberProvider")
    Long totalNumber();
}
