package com.hqh.controller;

import com.hqh.pojo.User;
import com.hqh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/User")
public class  LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(String userName, String password, HttpSession session, Model model){
        //调用service层的checkLogin（验证用户名和密码）的方法
        User user = userService.checkLogin(userName,password);
        //通过判断user是否为空来确定用户名和密码的正确
        if (user != null){
            //正确将user存入session中
            session.setAttribute("usr",user);
            //将页面定向到首页
            return "redirect:index.html";
        }
        model.addAttribute("msg","用户名或密码错误");
        //失败返回登录页面
        return "login";
    }


    @RequestMapping("loginOut")
    public String loginOut(HttpServletRequest request, HttpServletResponse response){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:login.html";
    }
}
