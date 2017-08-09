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


import data.mapper.UserInfoMapper;
import data.model.data.object.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @author liuzh
 * @since 2016-01-31 21:42
 */
@Service
public class UserInfoService {

    @Autowired
    private Environment env;

    @Autowired
    private UserInfoMapper userInfoMapper;


    public UserInfoDO insertUserInfo(){

        UserInfoDO userInfoDO = new UserInfoDO();

        userInfoDO.setUser_info_name("佟阳");

        userInfoDO.setUser_info_union_id("asfadf");

        userInfoDO.setUser_info_head_portraits("佟阳");

        userInfoMapper.saveUserInfoDO(userInfoDO);

        return userInfoDO;

    }

}
