package com.xh.service.impl;

import com.xh.dao.NewsUserMapper;
import com.xh.pojo.NewsUser;
import com.xh.service.NewsUserService;
import com.xh.service.NewsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsUserServiceImpl implements NewsUserService {
    @Autowired
    private NewsUserMapper newsUserMapper;

    @Override
    public NewsUser login(String userName, String password) {
        return newsUserMapper.selectUserByParam(userName,password);
    }

    @Override
    public List<NewsUser> selectUserList() {
        return newsUserMapper.selectUserList();
    }

    @Override
    public int insertUser(NewsUser newsUser) {
        return newsUserMapper.insertSelective(newsUser);
    }

    @Override
    public int deleteUser(Long long_id) {
        return newsUserMapper.deleteByPrimaryKey(long_id);
    }

    @Override
    public int updateUser(NewsUser newsUser) {
        return newsUserMapper.updateByPrimaryKeySelective(newsUser);
    }

    @Override
    public NewsUser findUserById(Long long_id) {
        return newsUserMapper.selectByPrimaryKey(long_id);
    }

    @Override
    public int findTotalUsers() {
        return newsUserMapper.findTotalUsers();
    }

}
