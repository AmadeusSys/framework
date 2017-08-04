package com.xiangmaikeji.framework.service.security;

import com.alibaba.druid.util.StringUtils;
import com.xiangmaikeji.framework.mapper.BaseUserInfoMapper;
import com.xiangmaikeji.framework.mapper.RuleMapper;
import com.xiangmaikeji.framework.model.BaseUserInfoDO;
import com.xiangmaikeji.framework.model.permission.RuleDO;
import com.xiangmaikeji.framework.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class testFilter extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    private FilterInvocationSecurityMetadataSource securityMetadataSource;

    @Autowired
    RuleMapper ruleMapper;

    @Autowired
    BaseUserInfoMapper baseUserInfoMapper;

    @Autowired
    TokenService tokenService;

    @Autowired
    public void setMyAccessDecisionManager(MyAccessDecisionManager myAccessDecisionManager) {
        super.setAccessDecisionManager(myAccessDecisionManager);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {



        String authToken = servletRequest.getParameter("token");

        if (!StringUtils.isEmpty(authToken) && tokenService.validateToken(authToken)){

            BaseUserInfoDO baseUserInfoDO = baseUserInfoMapper.getUserInfoDOByToken(authToken);

            if (baseUserInfoDO != null ) {

                List<RuleDO> ruleDOS = ruleMapper.listRuleByUserId(baseUserInfoDO.getUser_info_id());

                logger.info("checking authentication für user " + baseUserInfoDO.getUser_info_id());

                Collection<SimpleGrantedAuthority> collection = new ArrayList();

                for (RuleDO ruleDO : ruleDOS) {
                    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_"+ruleDO.getRule_name());
                    collection.add(simpleGrantedAuthority);
                }

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(baseUserInfoDO, null,collection);

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest)servletRequest));

                logger.info("authenticated user " + baseUserInfoDO.getUser_info_id() + ", setting security context");

                SecurityContextHolder.getContext().setAuthentication(authentication);

            }

        }

        FilterInvocation fi = new FilterInvocation(servletRequest, servletResponse, filterChain);

        InterceptorStatusToken token = super.beforeInvocation(fi);

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return securityMetadataSource;
    }
}
