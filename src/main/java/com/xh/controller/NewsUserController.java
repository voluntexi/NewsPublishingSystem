package com.xh.controller;

import com.xh.dao.NewsCommentMapper;
import com.xh.pojo.GraphBar;
import com.xh.pojo.NewsCategory;
import com.xh.pojo.NewsDetail;
import com.xh.pojo.NewsUser;
import com.xh.service.NewsCategoryService;
import com.xh.service.NewsCommentService;
import com.xh.service.NewsDetailService;
import com.xh.service.NewsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/production")
@Controller
public class NewsUserController {
    @Autowired
    private NewsUserService newUserService;
    @Autowired
    private NewsCategoryService newsCategoryService;
    @Autowired
    private NewsCommentService newsCommentService;
    @Autowired
    private NewsDetailService newsDetailService;
//    用户登录界面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
//    用户注销
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/production/toLogin";//重定向，不是转化
    }
//    登录成功跳转到主页
    @RequestMapping("/index")
    public String toindex(Model model){
        return "index";
    }
//    进行查询四个表（新闻，用户，主题，评论）中的数据数量，传值到前端
    @RequestMapping("/login")
    public String login(String userName, String userPassword, HttpSession session,Model model) {
        NewsUser newsUser = newUserService.login(userName, userPassword);
        if (newsUser != null) {
            int totalUsers=  newUserService.findTotalUsers();
            int totalComment=  newsCommentService.findTotalComment();
            int totalCategory= newsCategoryService.findTotalCategory();
            int totalNews=  newsDetailService.findTotalNews();
            session.setAttribute("totalUser",totalUsers);
            session.setAttribute("totalComment",totalComment);
            session.setAttribute("totalCategory",totalCategory);
            session.setAttribute("totalNews",totalNews);
            session.setAttribute("user", newsUser);
            return "index";
        } else {
            return "login";
        }
    }
//    //    获取所有的用户，传值到前端
    @RequestMapping("/findUserList")
    public String findUserList(Model model)
    {
        List<NewsUser> detailList=newUserService.selectUserList();
        model.addAttribute("list",detailList);
        return "user-table";
    }
    //    插入用户数据到数据库中
    @RequestMapping("/insertUser")
    public String insertUser(NewsUser newsUser)
    {
        return  newUserService.insertUser(newsUser)>0?"user-info":"user-form";
    }
//    跳转到用户修改页面
    @RequestMapping("/toUserForm")
    public String toUserForm(Model model)
    {
            return "user-form";
    }
//    修改用户信息，修改成功跳转消息提示页面
    @RequestMapping("/updateUser")
    public String updateUser(NewsUser newsUser,Model model){
        return newUserService.updateUser(newsUser)>0? "user-info": "user-form-update";
    }
//    删除用户，删除成功跳转消息提示页面
    @RequestMapping("/deleteUser")
    public  String deleteUser(String id)
    {
        Long long_id=Long.parseLong(id);
        return newUserService.deleteUser(long_id)>0?"user-info":"user-table";
    }
//    通过前端传值来的id进行查询用户id 插叙成功则跳转到用户修改页面
    @RequestMapping("/findUserById")
    public String findUserById(String userId,Model model)
    {
        Long long_id=Long.parseLong(userId);
        NewsUser newsUser= newUserService.findUserById(long_id);
        model.addAttribute("newsUser",newsUser);
        return newsUser!=null?"user-form-update":"user-table";
    }
//    当用户非法操作，跳转到403页面
    @RequestMapping("/403")
    public String false403( )
    {
        return "403";
    }

}
