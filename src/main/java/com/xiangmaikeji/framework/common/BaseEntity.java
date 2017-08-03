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

package com.xiangmaikeji.framework.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Transient;

/**
 * 基础信息
 *
 * @author liuzh
 * @since 2016-01-31 21:42
 */
public class BaseEntity {

    @JsonIgnore
    @ApiModelProperty(hidden=true)
    @Transient
    private Integer page = 1;

    @JsonIgnore
    @ApiModelProperty(hidden=true)
    @Transient
    private Integer rows = 25;

    @JsonIgnore
    @ApiModelProperty(hidden=true)
    @Transient
    private String searchPassWord;

    @JsonIgnore
    @ApiModelProperty(hidden=true)
    @Transient
    private Integer startLocation = 0;


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
        PageHelper.startPage(this.getPage(), this.getRows());
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getSearchPassWord() {
        return searchPassWord;
    }

    public void setSearchPassWord(String searchPassWord) {
        this.searchPassWord = searchPassWord;
    }

    public Integer getStartLocation() {
        return page * rows - rows;
    }

    public static Long calculateTotalPage(Long totalNumber){

        BaseEntity baseEntity = new BaseEntity();

        double floatNumber = totalNumber.doubleValue()/baseEntity.getRows().doubleValue();

        Double doublePage = Math.ceil(floatNumber);

        return doublePage.longValue();
    }

}
