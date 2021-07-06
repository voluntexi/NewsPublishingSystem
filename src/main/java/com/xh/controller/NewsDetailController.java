package com.xh.controller;

import com.alibaba.fastjson.JSON;
import com.xh.pojo.GraphBar;
import com.xh.pojo.NewsCategory;
import com.xh.pojo.NewsDetail;
import com.xh.service.NewsCategoryService;
import com.xh.service.NewsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@RequestMapping("/newsDetail")
@Controller
public class NewsDetailController {
    @Autowired
    private NewsDetailService newsDetailService;
    @Autowired
    private NewsCategoryService newsCategoryService;
//    获取所有的新闻内容，传值到前端
    @RequestMapping("/findNewsList")
    public String findNewsList(Model model)
    {
        List<NewsDetail> detailList=newsDetailService.selectNewsCategoryNameList();
        model.addAttribute("list",detailList);
        return "news-table";
    }
//    插入新闻数据到数据库中
    @RequestMapping("/insertNewsDetail")
    public String insertNewsDetail(NewsDetail newsDetail)
    {
        return  newsDetailService.insertNewsDetail(newsDetail)>0?"info-news":"news-form";
    }
//    查询数据库中新闻主题，传值到前端
    @RequestMapping("/toNewsForm")
    public String toNewsForm(Model model)
    {

        List<NewsCategory> newsCategoryList=newsCategoryService.findNewsCategoryList();
        model.addAttribute("list",newsCategoryList);
        return "news-form";
    }
//    查询前端传值的ID对应的新闻，查询成功跳转修改页面
    @RequestMapping("/findNewsById")
    public String findNewsById(String newsId,Model model)
    {
        Long long_id=Long.parseLong(newsId);
        NewsDetail newsDetail= newsDetailService.findNewsById(long_id);
        model.addAttribute("updateCatefory",newsDetail);
        List<NewsCategory> newsCategoryList=newsCategoryService.findNewsCategoryList();
        model.addAttribute("list",newsCategoryList);
        return newsDetail!=null?"news-form-update":"news-table";
    }
    //    修改新闻，修改成功跳转消息提示页面
    @RequestMapping("/updateNews")
    public String toCategoryUpdate(NewsDetail NewsDetail,Model model){
        return newsDetailService.updateDetail(NewsDetail)>0? "news-info": "news-form-update";
    }
//     删除新闻，删除成功跳转消息提示页面
    @RequestMapping("/deleteNews")
    public  String deleteNews(String id)
    {
        Long long_id=Long.parseLong(id);
        return newsDetailService.deleteNews(long_id)>0?"news-info":"news-table";
    }
//获取前端传来的新闻ID数据 进行连表查询，将新闻主题数据库中的主题名称和新闻内容中的主题ID进行查询 然后传值到前端
    @RequestMapping("/showDetails")
    public String showDetails(String newsId,Model model)
    {
        Long long_id=Long.parseLong(newsId);
        NewsDetail newsDetail= newsDetailService.selectNewsCategoryName(long_id);
        NewsCategory newsCategory=newsCategoryService.selectById(newsDetail.getCategoryid());
        model.addAttribute("newsDetail",newsDetail);
        List<NewsCategory> newsCategoryList=newsCategoryService.findNewsCategoryList();
        model.addAttribute("list",newsCategoryList);
        return "news-form-view";
    }
    //使用属性编辑器来进行处理Date类型数据
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
