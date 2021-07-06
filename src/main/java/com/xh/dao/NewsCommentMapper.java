package com.xh.dao;

import com.xh.pojo.NewsComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface NewsCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NewsComment record);

    int insertSelective(NewsComment record);

    NewsComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsComment record);

    int updateByPrimaryKey(NewsComment record);

    List<NewsComment> selectNewsCommenList();

    List<NewsComment> selectByNewsId(Long id);
    int findTotalComment();
}