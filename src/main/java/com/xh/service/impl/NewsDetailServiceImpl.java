package com.xh.service.impl;

import com.xh.dao.NewsDetailMapper;
import com.xh.pojo.GraphBar;
import com.xh.pojo.NewsDetail;
import com.xh.service.NewsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsDetailServiceImpl implements NewsDetailService {
    @Autowired
    private NewsDetailMapper newsDetailMapper;
    @Override
    public List<NewsDetail> findNewsDetailList() {

        return newsDetailMapper.selectNewsList();
    }

    @Override
    public List<NewsDetail> selectNewsCategoryNameList() {
        return newsDetailMapper.selectNewsCategoryNameList();
    }

    @Override
    public int insertNewsDetail(NewsDetail newsDetail) {
        return newsDetailMapper.insertSelective(newsDetail);
    }

    @Override
    public NewsDetail findNewsById(Long long_id) {
        return newsDetailMapper.selectByPrimaryKey(long_id);
    }

    @Override
    public int updateDetail(NewsDetail newsDetail) {
        return newsDetailMapper.updateByPrimaryKeySelective(newsDetail);
    }

    @Override
    public int deleteNews(Long long_id) {
        return newsDetailMapper.deleteByPrimaryKey(long_id);
    }

    @Override
    public NewsDetail selectNewsCategoryName(Long long_id) {
        return newsDetailMapper.selectByPrimaryKey(long_id);
    }

    @Override
    public List<GraphBar> selectGraphBarData() {
        return newsDetailMapper.selectGraphBarData();
    }

    @Override
    public int findTotalNews() {
        return newsDetailMapper.findTotalNews();
    }
}
