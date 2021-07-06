package com.xh.controller;

import com.xh.pojo.NewsCategory;
import com.xh.service.NewsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/category")
@Controller
public class NewsCategoryController {
    @Autowired
    private NewsCategoryService newsCategoryService;
//    获取所有的主题，传值到前端
    @RequestMapping("/findCategoryList")
    public String findCategoryList(Model model)
    {
        List<NewsCategory> list=newsCategoryService.findNewsCategoryList();
        model.addAttribute("list",list);
        return "category-table";
    }
//    跳转主题编辑页面
    @RequestMapping("/toCategoryForm")
    public String toCategoryForm()
    {
        return "category-form";
    }
//    插入新的主题
    @RequestMapping("/insertCategory")
    public String insertCategory(NewsCategory newsCategory)
    {
       return  newsCategoryService.insertCategory(newsCategory)>0?"info":"category-form";
    }
//    修改主题，修改成功跳转消息提示页面
    @RequestMapping("/updateCategory")
    public String toCategoryUpdate(NewsCategory newsCategory){
        int flag= newsCategoryService.updateCategory(newsCategory);
        if(flag>0){
            return "info";
        }else
        {
            return "category-form-update";
        }
    }
//    删除主题，删除成功跳转消息提示页面
    @RequestMapping("/deleteCategory")
    public String deleteCategory(NewsCategory newsCategory)
    {
        return newsCategoryService.deleteCategory(newsCategory)>0?"info":"category-table";
    }
//使用属性编辑器来进行处理Date类型数据
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
//    查询前端传值的ID对应的主题，查询成功跳转修改页面
    @RequestMapping("/selectCategoryById")
    public String updateCategoryById(String id,Model model){
        Long long_id=Long.parseLong(id);
        NewsCategory newsCategory= newsCategoryService.selectById(long_id);
        model.addAttribute("updateCatefory",newsCategory);
        if(newsCategory!=null){
            return "category-form-update";
        }
        else{
            return "category-table";
        }
    }
}
