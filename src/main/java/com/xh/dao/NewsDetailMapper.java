package com.xh.dao;

import com.xh.pojo.GraphBar;
import com.xh.pojo.NewsDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
public interface NewsDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NewsDetail record);

    int insertSelective(NewsDetail record);

    NewsDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsDetail record);

    int updateByPrimaryKeyWithBLOBs(NewsDetail record);

    int updateByPrimaryKey(NewsDetail record);
    List<NewsDetail> selectNewsList();

    List<NewsDetail> selectNewsCategoryNameList();
    List<GraphBar> selectGraphBarData();
    int findTotalNews();

}