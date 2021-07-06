package com.xh.service;

import com.xh.pojo.NewsUser;

import java.util.List;

public interface NewsUserService {
    NewsUser login(String userName, String password);
    List<NewsUser> selectUserList();

    int insertUser(NewsUser newsUser);

    int deleteUser(Long long_id);

    int updateUser(NewsUser newsUser);

    NewsUser findUserById(Long long_id);
    int findTotalUsers();
}
