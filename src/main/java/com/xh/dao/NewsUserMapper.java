package com.xh.dao;

import com.xh.pojo.NewsUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NewsUser record);

    int insertSelective(NewsUser record);

    NewsUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsUser record);

    int updateByPrimaryKey(NewsUser record);

    NewsUser selectUserByParam(@Param("userName") String userName,@Param("password") String password);
    List<NewsUser> selectUserList();
    int findTotalUsers();


}