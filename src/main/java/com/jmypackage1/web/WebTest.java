package com.jmypackage1.web;

import com.jmypackage1.pojo.User;
import com.jmypackage1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebTest {
    @Autowired
    private IUserService service;
    @RequestMapping("/list.do")
    public String index(ModelMap map){
        List<User> lists = service.getLists();
        map.put("lists",lists);
        return "list";
    }

    @RequestMapping("/addUser.do")
    public String addUser(){
        return "addUser";
    }

    @RequestMapping("/doAddUser.do")
    public String doAddUser(User user){
        service.insert(user);
        return "redirect:list.do";
    }

    @RequestMapping("/deleteUser.do")
    public String deleteUser(int id){
        service.deleUser(id);
        return "redirect:list.do";
    }

    @RequestMapping("/updateUser.do")
    public String updateUser(ModelMap map, int id){
        User user = service.getOne(id);
        map.put("user", user);
        return "updateUser";
    }

    @RequestMapping("/doUpdateUser.do")
    public String doUpdateUser(User user){
        service.amend(user);
        return "redirect:list.do";
    }
    @RequestMapping("/login.do")
    public  String login(){
        return "login";
    }
}
