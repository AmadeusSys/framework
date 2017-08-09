package data.model.data.object;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import data.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by TY on 2017/6/24.
 */
public class ProductDO extends BaseEntity {

    private String pbi_id;

    private String pdi_type;

    private String pbi_user_company_id;

    private String pdi_model_id;

    private String pbi_image_url;

    private String pbi_name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pbi_create_time;

    private BigDecimal pbi_price;

    private Long pdi_min_stock;

    private Long pdi_is_base_parts;

    private BigDecimal pdi_min_deposit_price;

    private Long pdi_pre_purchase_cycle;

    private Boolean pdi_is_delete;

    private Long pdi_sub_parts_number;

    private Long pdi_version;

    private Long pdi_brand_id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pdi_update_time;

    private String pbi_stock_number;

    private String pdi_unit;

    private String pbi_brand_name = "暂无";

    private String pbi_quote_price = "暂无报价";

    private String pbi_quote_name = "暂无报价公司";

    @JsonIgnore
    @ApiModelProperty(hidden=true)
    private String sortType;

    @JsonIgnore
    @ApiModelProperty(hidden=true)
    private String productType;



    public String getPbi_id() {
        return pbi_id;
    }

    public void setPbi_id(String pbi_id) {
        this.pbi_id = pbi_id;
    }

    public String getPdi_type() {
        return pdi_type;
    }

    public void setPdi_type(String pdi_type) {
        this.pdi_type = pdi_type;
    }

    public String getPbi_user_company_id() {
        return pbi_user_company_id;
    }

    public void setPbi_user_company_id(String pbi_user_company_id) {
        this.pbi_user_company_id = pbi_user_company_id;
    }

    public String getPdi_model_id() {
        return pdi_model_id;
    }

    public void setPdi_model_id(String pdi_model_id) {
        this.pdi_model_id = pdi_model_id;
    }

    public String getPbi_image_url() {
        return pbi_image_url;
    }

    public void setPbi_image_url(String pbi_image_url) {
        this.pbi_image_url = pbi_image_url;
    }

    public String getPbi_name() {
        return pbi_name;
    }

    public void setPbi_name(String pbi_name) {
        this.pbi_name = pbi_name;
    }

    public Date getPbi_create_time() {
        return pbi_create_time;
    }

    public void setPbi_create_time(Date pbi_create_time) {
        this.pbi_create_time = pbi_create_time;
    }

    public BigDecimal getPbi_price() {
        return pbi_price;
    }

    public void setPbi_price(BigDecimal pbi_price) {
        this.pbi_price = pbi_price;
    }

    public Long getPdi_min_stock() {
        return pdi_min_stock;
    }

    public void setPdi_min_stock(Long pdi_min_stock) {
        this.pdi_min_stock = pdi_min_stock;
    }

    public Long getPdi_is_base_parts() {
        return pdi_is_base_parts;
    }

    public void setPdi_is_base_parts(Long pdi_is_base_parts) {
        this.pdi_is_base_parts = pdi_is_base_parts;
    }

    public BigDecimal getPdi_min_deposit_price() {
        return pdi_min_deposit_price;
    }

    public void setPdi_min_deposit_price(BigDecimal pdi_min_deposit_price) {
        this.pdi_min_deposit_price = pdi_min_deposit_price;
    }

    public Long getPdi_pre_purchase_cycle() {
        return pdi_pre_purchase_cycle;
    }

    public void setPdi_pre_purchase_cycle(Long pdi_pre_purchase_cycle) {
        this.pdi_pre_purchase_cycle = pdi_pre_purchase_cycle;
    }

    public Boolean getPdi_is_delete() {
        return pdi_is_delete;
    }

    public void setPdi_is_delete(Boolean pdi_is_delete) {
        this.pdi_is_delete = pdi_is_delete;
    }

    public Long getPdi_sub_parts_number() {
        return pdi_sub_parts_number;
    }

    public void setPdi_sub_parts_number(Long pdi_sub_parts_number) {
        this.pdi_sub_parts_number = pdi_sub_parts_number;
    }

    public Long getPdi_version() {
        return pdi_version;
    }

    public void setPdi_version(Long pdi_version) {
        this.pdi_version = pdi_version;
    }

    public Long getPdi_brand_id() {
        return pdi_brand_id;
    }

    public void setPdi_brand_id(Long pdi_brand_id) {
        this.pdi_brand_id = pdi_brand_id;
    }

    public Date getPdi_update_time() {
        return pdi_update_time;
    }

    public void setPdi_update_time(Date pdi_update_time) {
        this.pdi_update_time = pdi_update_time;
    }

    public String getPbi_stock_number() {
        return pbi_stock_number;
    }

    public void setPbi_stock_number(String pbi_stock_number) {
        this.pbi_stock_number = pbi_stock_number;
    }

    public String getPdi_unit() {
        return pdi_unit;
    }

    public void setPdi_unit(String pdi_unit) {
        this.pdi_unit = pdi_unit;
    }

    public String getPbi_brand_name() {
        return pbi_brand_name;
    }

    public void setPbi_brand_name(String pbi_brand_name) {
        this.pbi_brand_name = pbi_brand_name;
    }

    public String getPbi_quote_price() {
        return pbi_quote_price;
    }

    public void setPbi_quote_price(String pbi_quote_price) {
        this.pbi_quote_price = pbi_quote_price;
    }

    public String getPbi_quote_name() {
        return pbi_quote_name;
    }

    public void setPbi_quote_name(String pbi_quote_name) {
        this.pbi_quote_name = pbi_quote_name;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
