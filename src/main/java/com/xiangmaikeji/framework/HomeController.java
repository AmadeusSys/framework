package com.xiangmaikeji.framework;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class HomeController {

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
    public String login(){
        return "login";
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
