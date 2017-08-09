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


import component.tool.CommonConf;
import component.tool.YTNetTool;
import data.mapper.UserInfoMapper;
import data.mapper.UserTokenMapper;
import data.model.data.object.UserInfoDO;
import data.model.data.object.UserTokenDO;
import data.model.data.transfer.object.DD.DDTokenDTO;
import data.model.data.transfer.object.DD.DDUserDTO;
import data.model.data.transfer.object.DD.DDUserDetailsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzh
 * @since 2016-01-31 21:42
 */
@Service
public class DDLoginService {

    private static final String BASEURL = "https://oapi.dingtalk.com/";

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserTokenMapper userTokenMapper;

    @Autowired
    DDService ddService;

    @Autowired
    private CommonConf conf;

    @Autowired
    private YTNetTool ytNetTool;

    protected Logger logger = LoggerFactory.getLogger(DDLoginService.class);

    /**
     * 获取内部用户信息以及token
     * @param code 钉钉系统jsAPI code
     * @return 包含toke及用户信息的Map
     * @throws DDServiceException
     * @throws IOException
     */
    public Map getUserAndToken(String code) throws DDServiceException, IOException {

        //获取钉钉用户
        DDUserDTO ddUserDTO = this.getDDUserInfo(code);

        //获取丁丁用户详细
        DDUserDetailsDTO ddUserDetailsDTO = this.getDDUserDetails(ddUserDTO.getUserid());

        //维护数据库用户信息
        UserInfoDO userInfoDO = this.maintainUserInfo(ddUserDetailsDTO);

        //生产用户token
        UserTokenDO userTokenDO = UserTokenDO.init(ddUserDTO.getDeviceId(), userInfoDO.getUser_info_id());

        //保存到数据库
        userTokenMapper.insert(userTokenDO);

        Map returnData = new HashMap();

        returnData.put("TokenValue", userTokenDO.getUt_id());

        returnData.put("UserInfo", userInfoDO);

        return returnData;

    }

    /**
     * 维护用户信息如果用户不存在则新建如果用户已经存在则更新名称和头像
     * @param ddUserDetailsDTO
     * @return 逻辑用户信息
     */
    public UserInfoDO maintainUserInfo(DDUserDetailsDTO ddUserDetailsDTO){

        UserInfoDO user = UserInfoDO.init(ddUserDetailsDTO);

        UserInfoDO userInfoDO = userInfoMapper.getUserInfoDO(user);

        if (userInfoDO == null){

            userInfoMapper.addUserInfoDO(user);

        }else{

            userInfoMapper.saveUserInfoDO(user);

        }

        return user;

    }

    /**
     * 获取钉钉系统用户详细信息
     * @param userId
     * @return 钉钉系统用户model
     * @throws DDServiceException
     * @throws IOException
     */
    @Cacheable(cacheNames="DDUserDetailsnModel", key="#userId")
    public DDUserDetailsDTO getDDUserDetails(String userId) throws DDServiceException, IOException {

        String url = BASEURL + "user/get";

        Map fromData = new HashMap();

        DDTokenDTO ddTokenDTO = ddService.getToken(conf.getDDCorpId(),conf.getDDCorpSecret());

        fromData.put("access_token", ddTokenDTO.getAccess_token());

        fromData.put("userid",userId);

        DDUserDetailsDTO ddUserDetailsDTO = ytNetTool.yt_GetRequest(url,fromData,DDUserDetailsDTO.class);

        if (ddUserDetailsDTO.isOK()){
            return ddUserDetailsDTO;
        }else{

            throw new DDServiceException(ddUserDetailsDTO.getErrmsg(), ddUserDetailsDTO.getErrcode());
        }

    }

    /**
     * 获取钉钉用户信息
     * @param code jsAPI返回的授权code
     * @return 钉钉用户model
     * @throws DDServiceException
     * @throws IOException
     */
    public DDUserDTO getDDUserInfo(String code) throws DDServiceException, IOException {

        String url = BASEURL + "user/getuserinfo";

        Map fromData = new HashMap();

        DDTokenDTO ddTokenDTO = ddService.getToken(conf.getDDCorpId(),conf.getDDCorpSecret());

        fromData.put("access_token", ddTokenDTO.getAccess_token());

        fromData.put("code",code);

        DDUserDTO ddUserDTO = ytNetTool.yt_GetRequest(url,fromData,DDUserDTO.class);

        if (ddUserDTO.isOK()){
            return ddUserDTO;
        }else{

            throw new DDServiceException(ddUserDTO.getErrmsg(), ddUserDTO.getErrcode());
        }

    }


}
