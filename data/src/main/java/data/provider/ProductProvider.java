package data.provider;


import data.model.data.object.ProductDO;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by TY on 2017/7/28.
 */
public class ProductProvider {

    public  static final String TABLE_NAME = "t_logic_product_base_info";

    private static final  String BASE_FIELD = "pbi_id,pdi_type,pdi_unit,pbi_user_company_id,pdi_model_id,pbi_image_url,pbi_name,pbi_create_time,pbi_price,pdi_min_stock,pdi_is_base_parts,pdi_min_deposit_price,pdi_pre_purchase_cycle,pdi_is_delete,pdi_sub_parts_number,pdi_version,pdi_brand_id,pdi_update_time";

    public String listProductProvider(ProductDO productDO){

        return new SQL(){{

            SELECT(BASE_FIELD);

            FROM(TABLE_NAME);

            if ("HIDDEN_NO_STOCK".equals(productDO.getSortType())){
                WHERE("pbi_stock_number > 0");
            }

//            LIMIT("#{productDO.startLocation},#{productDO.rows}");

        }}.toString();

    }
}
