package permission.service;


import data.common.BaseEntity;
import data.mapper.ContractMapper;
import data.model.data.object.ContractDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContractService {

    @Autowired
    ContractMapper contractMapper;

    public Long getTotalPage(){
        return BaseEntity.calculateTotalPage(contractMapper.totalNumber());
    }

    public List listContract(Integer page,String searchPassWord){

        ContractDo contractDo = new ContractDo();

        contractDo.setPage(page);

        contractDo.setSearchPassWord(searchPassWord);

        return contractMapper.listContract(contractDo);

    }

    public ContractDo addContract(ContractDo contractDo){

        if (contractDo.getContract_create_time() == null){
            contractDo.setContract_create_time(new Date());
        }

        contractMapper.addContract(contractDo);

        return contractDo;

    }

    public ContractDo saveContract(ContractDo contractDo){

        contractMapper.saveContract(contractDo);

        return contractDo;

    }

    public ContractDo getContract(String id){
        return contractMapper.getContract(id);
    }

}
