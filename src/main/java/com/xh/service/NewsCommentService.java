package com.xh.service;

import com.xh.pojo.NewsComment;

import java.util.List;
public interface NewsCommentService {
    List<NewsComment> findNewsCommentList();
    int insertComment(NewsComment newsComment);
    NewsComment findCommentById(Long long_id);

    int deleteComment(Long long_id);

    int updateComment(NewsComment newsComment);

    int insertNewsComment(NewsComment newsComment);

    List<NewsComment> findCommentByNewsId(Long long_id);

    int findTotalComment();
}
