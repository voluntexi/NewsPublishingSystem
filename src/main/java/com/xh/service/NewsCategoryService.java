package com.xh.service;

import com.xh.pojo.NewsCategory;

import java.util.List;

public interface NewsCategoryService {
    List<NewsCategory> findNewsCategoryList();

    int insertCategory(NewsCategory newsCategory);

    int deleteCategory(NewsCategory newsCategory);

    int updateCategory(NewsCategory id);

    NewsCategory selectById(Long long_id);

    int findTotalCategory();
}
