package com.xh.service.impl;

import com.xh.dao.NewsCommentMapper;
import com.xh.pojo.NewsComment;
import com.xh.service.NewsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsCommentServiceImpl implements NewsCommentService {
    @Autowired
    private NewsCommentMapper newsCommentMapper;

    @Override
    public List<NewsComment> findNewsCommentList() {
        return newsCommentMapper.selectNewsCommenList();
    }
    @Override
    public int insertComment(NewsComment newsComment) {
        return newsCommentMapper.insertSelective(newsComment);
    }

    @Override
    public NewsComment findCommentById(Long long_id) {
        return newsCommentMapper.selectByPrimaryKey(long_id);
    }

    @Override
    public int deleteComment(Long long_id) {
        return newsCommentMapper.deleteByPrimaryKey(long_id);
    }

    @Override
    public int updateComment(NewsComment newsComment) {
        return newsCommentMapper.updateByPrimaryKeySelective(newsComment);
    }

    @Override
    public int insertNewsComment(NewsComment newsComment) {
        return newsCommentMapper.insertSelective(newsComment);
    }

    @Override
    public List<NewsComment> findCommentByNewsId(Long long_id) {
        return newsCommentMapper.selectByNewsId(long_id);
    }

    @Override
    public int findTotalComment() {
        return newsCommentMapper.findTotalComment();
    }
}
