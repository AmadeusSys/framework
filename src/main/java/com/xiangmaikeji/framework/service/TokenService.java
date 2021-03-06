package com.xiangmaikeji.framework.service;

import data.mapper.UserTokenMapper;
import data.model.data.object.UserTokenDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TokenService{

    @Autowired
    UserTokenMapper userTokenMapper;

    @Transactional
    public String getToken(String userId){

        UserTokenDO userTokenDO = UserTokenDO.init(userId);

        userTokenMapper.addUserToken(userTokenDO);

        return userTokenDO.getUt_id();

    }


    public Boolean validateToken(String token){
        return true;
    }

}