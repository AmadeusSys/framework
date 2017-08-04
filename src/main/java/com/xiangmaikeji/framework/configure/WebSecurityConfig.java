package com.xiangmaikeji.framework.configure;

import com.xiangmaikeji.framework.service.security.MyFilterSecurityInterceptor;
import com.xiangmaikeji.framework.service.security.ServiceUnauthorizedEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ServiceUnauthorizedEntryPoint serviceUnauthorizedEntryPoint;

//    @Autowired
//    testFilter testFilter;

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //无需权限的路径
        http.authorizeRequests().antMatchers("/login").permitAll();

        //需要权限的路径
        http.authorizeRequests().anyRequest().authenticated();

        //无权限的空处理
        http.exceptionHandling().authenticationEntryPoint(serviceUnauthorizedEntryPoint);

        //不使用session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //禁用CSRF
        http.csrf().disable();

        //添加过滤器
        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
       // http.addFilterBefore(testFilter, FilterSecurityInterceptor.class);
        //禁止缓存
        http.headers().cacheControl();

    }

    @Bean
    public MyFilterSecurityInterceptor authenticationTokenFilterBean() throws Exception {
        return new MyFilterSecurityInterceptor();
    }

}
