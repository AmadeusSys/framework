/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package permission.service;


import data.mapper.DictionaryMapper;
import data.mapper.ProductMapper;
import data.model.data.object.DictionaryDO;
import data.model.data.object.ProductDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzh
 * @since 2016-01-31 21:42
 */
@Service
public class ProductInfoService {

    @Autowired
    private Environment env;

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Autowired
    private ProductMapper productMapper;

    public Map getProductInfo(String productId){

        ProductDO productDO = new ProductDO();

        productDO.setPbi_id(productId);

        productDO = productMapper.getProductDo(productDO);

        Map returnData = new HashMap();

        returnData.put("ProductInfo",productDO);

        return returnData;

    }

    public Map getProductList(Integer page,String searchPassWord,String sortType, String productType){

        List<DictionaryDO> productTypeDOList = dictionaryMapper.listDictionary(DictionaryDO.init("ProductType"));

        ProductDO productDO = new ProductDO();

        productDO.setPage(page);

        productDO.setSearchPassWord(searchPassWord);

        productDO.setSortType(sortType);

        productDO.setProductType(productType);

        List<ProductDO> productList = productMapper.listProductDO(productDO);

        Map filterData = new HashMap();

        filterData.put("ProductType",productTypeDOList);

        filterData.put("SortType",this.getSortTypeList());

        Map returnData = new HashMap();

        returnData.put("FilterData",filterData);

        returnData.put("ProductList",productList);

        return returnData;
    }

    public List getSortTypeList(){

        List sorlTypeList = new ArrayList();

//        sorlTypeList.add(new HashMap(){ {
//            put("SortType",ProductOrderEnum.UPDATE_TIME_ASCENDING);
//            put("SortText", "更新时间正序");
//        } });
//
//        sorlTypeList.add(new HashMap(){ {
//            put("SortType",ProductOrderEnum.UPDATE_TIME_DESCENDING);
//            put("SortText", "更新时间倒叙序");
//        } });
//
//        sorlTypeList.add(new HashMap(){ {
//            put("SortType",ProductOrderEnum.HIDDEN_NO_STOCK);
//            put("SortText", "隐藏无库存");
//        } });

        return sorlTypeList;

    }



}
