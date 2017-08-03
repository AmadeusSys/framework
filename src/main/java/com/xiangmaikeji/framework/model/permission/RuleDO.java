package com.xiangmaikeji.framework.model.permission;

import javax.persistence.Table;

@Table(name = "t_permission_rule")
public class RuleDO {

    private String rule_id;
    private Integer rule_is_delete;
    private String rule_parent_id;
    private String  rule_name;
    private String  rule_descritpion;

    public String getRule_id() {
        return rule_id;
    }

    public void setRule_id(String rule_id) {
        this.rule_id = rule_id;
    }

    public Integer getRule_is_delete() {
        return rule_is_delete;
    }

    public void setRule_is_delete(Integer rule_is_delete) {
        this.rule_is_delete = rule_is_delete;
    }

    public String getRule_parent_id() {
        return rule_parent_id;
    }

    public void setRule_parent_id(String rule_parent_id) {
        this.rule_parent_id = rule_parent_id;
    }

    public String getRule_name() {
        return rule_name;
    }

    public void setRule_name(String rule_name) {
        this.rule_name = rule_name;
    }

    public String getRule_descritpion() {
        return rule_descritpion;
    }

    public void setRule_descritpion(String rule_descritpion) {
        this.rule_descritpion = rule_descritpion;
    }
}
