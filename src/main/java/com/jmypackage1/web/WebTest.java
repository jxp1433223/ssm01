package com.jmypackage1.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmypackage1.pojo.User;
import com.jmypackage1.service.IUserService;
import com.jmypackage1.service.UserServiceImpl;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class WebTest {
    @Autowired
    private IUserService service;
    @RequestMapping("/list.do")
    public String index(ModelMap map, HttpServletRequest req,User user){
        int pageNum=req.getParameter("pageNum")==null?1:Integer.parseInt(req.getParameter("pageNum"));
       int pageSzie=1;
        PageHelper.startPage(pageNum,pageSzie);
        List<User> lists=null;
        if (StringUtils.isBlank(user.getUsername())){
            user.setUsername(null);
            lists = service.getLists(user);
        }else {
            lists=service.getLists(user);
            String uname="&username="+user.getUsername();
            map.put("uname",uname);
        }
        PageInfo<User> page=new PageInfo<>(lists,5);
       map.put("lists",lists);
        map.put("page",page);
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
    @RequestMapping("/upload.do")
    public  String upload(){
        return "upload";
    }
    @RequestMapping("/register.do")
    public String register(){
        return "register";
    }
    @RequestMapping("/doRegister.do")
    private  String  doregister(String uname,String pwd,String pwds,String tele,String answer){
        if(uname!="") {
            User user = service.getTwo(uname);
            if (pwd!=""&&pwd.equals(pwds)){
                return "4";
            }else {
                return  "3";
            }
        }
        return  "register";
    }
    @RequestMapping("/doupload.do")
    private String doupload(@RequestParam("files") MultipartFile[] files){
        for (MultipartFile f:files
             ) {
            if (!f.isEmpty()){

                try {
                    File file=new File("C:\\Users\\Administrator\\Desktop\\img(2)\\"+f.getOriginalFilename());
                    FileUtils.copyInputStreamToFile(f.getInputStream(),file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    @RequestMapping("/login.do")
    public  String login(){
        return "login";
    }
    @RequestMapping("/dologin.do")
    public String doLogin( String username, String password, HttpServletRequest req, HttpServletResponse resp){
        User user = service.getTwo(username);
        System.out.println(user);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(60 * 60 * 24 * 7);
                resp.addCookie(cookie);
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                return "redirect:list.do";
            } else {
                return "login";
            }
        }else {
            return "login";
        }
    }

}
