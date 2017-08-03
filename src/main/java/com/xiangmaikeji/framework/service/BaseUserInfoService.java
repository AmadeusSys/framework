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

package com.xiangmaikeji.framework.service;

import com.xiangmaikeji.framework.mapper.BaseUserInfoMapper;
import com.xiangmaikeji.framework.mapper.RuleMapper;
import com.xiangmaikeji.framework.model.BaseUserInfoDO;
import com.xiangmaikeji.framework.model.permission.RuleDO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzh
 * @since 2015-12-19 11:09
 */
@Service
public class BaseUserInfoService implements UserDetailsService {

    @Autowired
    private BaseUserInfoMapper baseUserInfoMapper;

    @Autowired
    private RuleMapper ruleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        BaseUserInfoDO baseUserInfoDO = baseUserInfoMapper.getUserInfoDOByToken(s);

        if (baseUserInfoDO == null){
            throw new UsernameNotFoundException(s);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList();

        List<RuleDO> ruleDOS = ruleMapper.listRuleByUserId(s);

        //添加权限到集合中
        for (RuleDO role : ruleDOS){
            if (role != null && role.getRule_name() != null) {

                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRule_name());

                grantedAuthorities.add(grantedAuthority);

            }
        }

        User user = new User(baseUserInfoDO.getUser_info_name(),"123546", grantedAuthorities);

        return user;

    }


    public List<BaseUserInfoDO> getAll(BaseUserInfoDO baseUserInfoDO) {
        return baseUserInfoMapper.selectAll();
    }

    public BaseUserInfoDO getById(Integer id) {
        return baseUserInfoMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        baseUserInfoMapper.deleteByPrimaryKey(id);
    }

    public void save(BaseUserInfoDO baseUserInfoDO) {
        if (baseUserInfoDO.getUser_info_id() != null) {
            baseUserInfoMapper.updateByPrimaryKey(baseUserInfoDO);
        } else {
            baseUserInfoMapper.insert(baseUserInfoDO);
        }
    }
}
