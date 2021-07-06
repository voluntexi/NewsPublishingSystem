package com.xh.dao;

import com.xh.pojo.NewsCategory;
import com.xh.pojo.NewsDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface NewsCategoryMapper {
    List<NewsCategory> selectCategoryList();
    int deleteByPrimaryKey(Long id);

    int insert(NewsCategory record);

    int insertSelective(NewsCategory record);

    NewsCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsCategory newsCategory);

    int updateByPrimaryKey(NewsCategory record);
    int findTotalCategory();
}