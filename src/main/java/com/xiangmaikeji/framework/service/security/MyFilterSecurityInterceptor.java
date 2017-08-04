package com.xiangmaikeji.framework.service.security;

import com.alibaba.druid.util.StringUtils;
import com.xiangmaikeji.framework.mapper.BaseUserInfoMapper;
import com.xiangmaikeji.framework.mapper.RuleMapper;
import com.xiangmaikeji.framework.model.BaseUserInfoDO;
import com.xiangmaikeji.framework.model.permission.RuleDO;
import com.xiangmaikeji.framework.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


public class MyFilterSecurityInterceptor extends OncePerRequestFilter {


    private String tokenHeader = "token";

    @Autowired
    RuleMapper ruleMapper;

    @Autowired
    BaseUserInfoMapper baseUserInfoMapper;

    @Autowired
    TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String url = httpServletRequest.getServletPath().toUpperCase();

        String authToken = httpServletRequest.getParameter(this.tokenHeader);

        if (!StringUtils.isEmpty(authToken) && tokenService.validateToken(authToken)){

            BaseUserInfoDO baseUserInfoDO = baseUserInfoMapper.getUserInfoDOByToken(authToken);

            if (baseUserInfoDO != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                Map map = new HashMap<>();

                map.put("path",url);

                map.put("userId",baseUserInfoDO.getUser_info_id());

                RuleDO ruleDOa = ruleMapper.getRuleByUserIdAndPath(map);

                logger.info("checking authentication für user " + baseUserInfoDO.getUser_info_id());

                Collection<SimpleGrantedAuthority> collection = new ArrayList();

                if (ruleDOa != null){

                    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_"+ruleDOa.getRule_name());

                    collection.add(simpleGrantedAuthority);

                }else{

                    throw new AccessDeniedException("no right");

                }

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(baseUserInfoDO, null,collection);

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                logger.info("authenticated user " + baseUserInfoDO.getUser_info_id() + ", setting security context");

                SecurityContextHolder.getContext().setAuthentication(authentication);

            }

        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }

}
