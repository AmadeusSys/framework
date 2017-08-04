package com.xiangmaikeji.framework;

import com.xiangmaikeji.framework.mapper.BaseUserInfoMapper;
import com.xiangmaikeji.framework.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    TokenService tokenService;

    @Autowired
    BaseUserInfoMapper baseUserInfoMapper;

    @RequestMapping("/")
    public String index(){

        return "home";
    }


    @RequestMapping("/admin")
    @ResponseBody
    public String hello(){
        return "hello admin";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String userId){

        Authentication authentication = new UsernamePasswordAuthenticationToken(userId,"null" );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return tokenService.getToken(userId);

    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public String getList(){
        return "hello getList";
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public String save(){
        return "hello save";
    }


    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public String update(){
        return "hello update";
    }

}
