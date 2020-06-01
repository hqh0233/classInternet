package com.hqh.controller;

import com.hqh.pojo.Notice;
import com.hqh.pojo.User;
import com.hqh.pojo.UserEvent;
import com.hqh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
/*
 * 
 * @param null 
 * @return 
 * @author heqianghua
 * @creed: Talk is cheap,show me the code
 * @date 2020/1/20 20:55
 */
@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

   /* @RequestMapping("/")
    public String hello(){
        return "login";
    }*/
/*查询全部同学信息
 *
 * @param model
 * @return java.lang.String
 * @author heqianghua
 * @creed: Talk is cheap,show me the code
 * @date 2020/2/18 19:57
 */
   @RequestMapping("/5")
    public String list(Model model){
        List<User> usersAll=userService.queryAllUser();
       //System.out.println(usersAll);
        model.addAttribute("usersAll",usersAll);
        return "5";
    }
/*更新个人信息
 *
 * @param user
	 * @param session
 * @return java.lang.String
 * @author heqianghua
 * @creed: Talk is cheap,show me the code
 * @date 2020/2/18 20:39
 */
    @RequestMapping("/updateUser")
    public String updatePaper(User user,HttpSession session,Model model){
        //System.out.println(user);
        userService.updateUser(user);
//        System.out.println(session.getAttribute("usr"));
        List<User> usersAll=userService.queryAllUser();
        //System.out.println(usersAll);
        model.addAttribute("usersAll",usersAll);
       return "redirect:/User/6";
    }
    /*
     * 查询个人信息根据id
     * @param null
     * @return
     * @author heqianghua
     * @creed: Talk is cheap,show me the code
     * @date 2020/2/18 20:40
     */
    @RequestMapping("/6")
    public String listUser(Model model,HttpSession session){
        User user1= (User) session.getAttribute("usr");
        User user2=userService.queryUserById(user1.getId());
        session.setAttribute("usr",user2);
        model.addAttribute("user2",user2);
        return "6";
    }

   /*更新密码
    *
    * @param password
   	 * @param id
    * @return java.lang.String
    * @author heqianghua
    * @creed: Talk is cheap,show me the code
    * @date 2020/2/19 14:49
    */
    @RequestMapping("/updatePassword")
    public String updatePass(String password, int id, HttpSession session,Model model){
        //System.out.println(password+id);
        userService.updateUserPassword(password,id);
        session.invalidate();
        return "redirect:login.html";
    }

    /*查询所有公告,动态
     *
     * @param model
     * @return java.lang.String
     * @author heqianghua
     * @creed: Talk is cheap,show me the code
     * @date 2020/2/19 14:48
     */
    @RequestMapping("/index.html")
    public String lists(Model model){
        List<Notice> notices=userService.queryAllNotice();
        List<UserEvent> userEvents=userService.queryAllUserEvent();
        model.addAttribute("userEvents",userEvents);
        model.addAttribute("notices",notices);
        return "index1";
    }

    /*
     * 发布动态
     * @param userEvent
     * @return java.lang.String
     * @author heqianghua
     * @creed: Talk is cheap,show me the code
     * @date 2020/2/19 19:31
     */
    @RequestMapping("/addEvent")
    public String addUserEvent(UserEvent userEvent){
        userService.addUserEvent(userEvent);
        return "redirect:/User/index.html";
    }
}
