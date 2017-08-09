package data.model.data.object;

import com.fasterxml.jackson.annotation.JsonFormat;
import data.common.BaseEntity;


import java.util.Date;

public class ContractDo extends BaseEntity {

    private String contract_id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date contract_create_time;

    private String contract_content;

    private String contract_create_user_id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date contract_update_time;

    private String contract_name;

    public String getContract_id() {
        return contract_id;
    }

    public void setContract_id(String contract_id) {
        this.contract_id = contract_id;
    }

    public String getContract_content() {
        return contract_content;
    }

    public void setContract_content(String contract_content) {
        this.contract_content = contract_content;
    }

    public String getContract_create_user_id() {
        return contract_create_user_id;
    }

    public void setContract_create_user_id(String contract_create_user_id) {
        this.contract_create_user_id = contract_create_user_id;
    }

    public String getContract_name() {
        return contract_name;
    }

    public void setContract_name(String contract_name) {
        this.contract_name = contract_name;
    }

    public Date getContract_create_time() {
        return contract_create_time;
    }

    public void setContract_create_time(Date contract_create_time) {
        this.contract_create_time = contract_create_time;
    }

    public Date getContract_update_time() {
        return contract_update_time;
    }

    public void setContract_update_time(Date contract_update_time) {
        this.contract_update_time = contract_update_time;
    }
}
