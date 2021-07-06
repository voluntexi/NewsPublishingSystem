package com.xh.service;

import com.xh.pojo.GraphBar;
import com.xh.pojo.NewsDetail;

import java.util.List;
public interface NewsDetailService {
    List<NewsDetail>findNewsDetailList();
    List<NewsDetail>selectNewsCategoryNameList();
    int insertNewsDetail(NewsDetail newsDetail);
    NewsDetail findNewsById(Long long_id);

    int updateDetail(NewsDetail newsDetail);

    int deleteNews(Long long_id);

    NewsDetail selectNewsCategoryName(Long long_id);
    List<GraphBar> selectGraphBarData();

    int findTotalNews();
}
