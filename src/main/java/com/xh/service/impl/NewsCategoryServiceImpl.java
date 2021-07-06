package com.xh.service.impl;

import com.xh.dao.NewsCategoryMapper;
import com.xh.pojo.NewsCategory;
import com.xh.service.NewsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsCategoryServiceImpl implements NewsCategoryService {
    @Autowired
    private NewsCategoryMapper newsCategoryMapper;

    @Override
    public List<NewsCategory> findNewsCategoryList() {
        return newsCategoryMapper.selectCategoryList();
    }

    @Override
    public int insertCategory(NewsCategory newsCategory) {
        return newsCategoryMapper.insertSelective(newsCategory);
    }

    @Override
    public int deleteCategory(NewsCategory newsCategory) {
        return newsCategoryMapper.deleteByPrimaryKey(newsCategory.getId());
    }

    @Override
    public int updateCategory(NewsCategory newsCategory) {
        return newsCategoryMapper.updateByPrimaryKeySelective(newsCategory);
    }

    @Override
    public NewsCategory selectById(Long long_id) {
        return newsCategoryMapper.selectByPrimaryKey(long_id);
    }

    @Override
    public int findTotalCategory() {
        return newsCategoryMapper.findTotalCategory();
    }

}
