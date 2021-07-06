package com.xh.controller;

import com.xh.pojo.NewsCategory;
import com.xh.pojo.NewsComment;
import com.xh.pojo.NewsComment;
import com.xh.pojo.NewsUser;
import com.xh.service.NewsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/comment")
@Controller
public class NewsCommentController {
    @Autowired
    private NewsCommentService newsCommentService;
//    查询所有的评论
    @RequestMapping("/findCommentList")
    public String findCommentList(Model model)
    {
            List<NewsComment> List=newsCommentService.findNewsCommentList();
            model.addAttribute("list",List);
            return "comment-table";
    }

    // TODO: 2021/7/4 ajax 调用 ResponseBody注解  将java对象转为json格式的数据。然后将数据进行插入
    @ResponseBody
    @RequestMapping("/insertComment")
    public String insertComment(String contentVal, String newsId,HttpSession session, HttpServletRequest request)
    {
        NewsUser user= (NewsUser) session.getAttribute("user");
        NewsComment newsComment=new NewsComment();
        newsComment.setContent(contentVal);
        newsComment.setAuthor(user.getUsername());
        newsComment.setNewsid(Long.valueOf(newsId));
        newsComment.setCreatedate(new Date());
        newsComment.setIp(request.getRemoteAddr());
        newsComment.setId(user.getId());
        return  newsCommentService.insertNewsComment(newsComment)>0?"true":"false";
    }
//    将前端传入的ID 在数据库中查询，返回需要的数据
    @ResponseBody
    @RequestMapping(value = "/showAllComment" ,method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String showAllComment(String newsId)
    {
        Long long_id=Long.parseLong(newsId);
        List<NewsComment> newsComment= newsCommentService.findCommentByNewsId(long_id);
        String res="";
        for (NewsComment comment:
             newsComment) {
            res+="<div class=\"row\"><div class=\"col-md-12 col-sm-12 col-xs-12\"><div class=\"x_panel\">" + "<div class=\"x_title\">" +
                    "<p> <h4>用户昵称： "+comment.getAuthor()+"</h4><br> <h4>评论内容："+comment.getContent()+"</h4><br>"+
                    "<h4>评论IP："+comment.getIp()+"</h4><br>"
                    +"<h4>评论时间："+new Date()+"</h4> <br>"+
                    "</div></div></div></div>";
        }
        return res;
    }
//    查询前端传值的ID对应的主题，查询成功跳转修改页面
    @RequestMapping("/selectCommentById")
    public String selectNewsById(String newsId,Model model)
    {
        Long long_id=Long.parseLong(newsId);
        NewsComment newsComment= newsCommentService.findCommentById(long_id);
        model.addAttribute("updateComment",newsComment);
        return newsComment!=null?"comment-form-update":"comment-table";
    }
    //    修改主题，修改成功跳转消息提示页面
    @RequestMapping("/updateNews")
    public String toCategoryUpdate(NewsComment NewsComment,Model model){
        return newsCommentService.updateComment(NewsComment)>0? "comment-info": "comment-form-update";
    }
    //    删除主题，删除成功跳转消息提示页面
    @RequestMapping("/deleteComment")
    public  String deleteNews(String id)
    {
        Long long_id=Long.parseLong(id);
        return newsCommentService.deleteComment(long_id)>0?"comment-info":"comment-table";
    }
    //使用属性编辑器来进行处理Date类型数据
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
