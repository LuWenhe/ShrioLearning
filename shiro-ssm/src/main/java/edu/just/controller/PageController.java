package edu.just.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//专门用于显示页面的控制器
@Controller
@RequestMapping("")
public class PageController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    /**
     * 用户需要有 deleteOrder 权限
     */
    @RequiresPermissions("deleteOrder")
    @RequestMapping("deleteOrder")
    public String deleteOrder(){
        return "deleteOrder";
    }

    /**
     * 用户需要有 productManager 的角色
     */
    @RequiresRoles("productManager")
    @RequestMapping("deleteProduct")
    public String deleteProduct(){
        return "deleteProduct";
    }

    @RequestMapping("listProduct")
    public String listProduct(){
        return "listProduct";
    }

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping("unauthorized")
    public String noPerms(){
        return "unauthorized";
    }



}
