package com.xh.controller;
import com.alibaba.fastjson.JSON;
import com.xh.pojo.GraphBar;
import com.xh.service.NewsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@RequestMapping("/index")
@Controller
public class IndexController {
    @Autowired
    private NewsDetailService newsDetailService;
    @ResponseBody
    @RequestMapping(value = "/findGraphBarData",
            produces = "application/json;charset=utf-8")
    //获取新闻主题下对应的新闻的数量
    public String findGraphBarData(){
        List<GraphBar> list=newsDetailService.selectGraphBarData();
        String result= JSON.toJSONString(list);
        System.out.println(result);
        return result;
    }
}
