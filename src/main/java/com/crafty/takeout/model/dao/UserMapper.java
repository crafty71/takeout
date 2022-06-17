package com.crafty.takeout.model.dao;

import com.crafty.takeout.model.pojo.User;

public interface UserMapper {

  int deleteByPrimaryKey(Long id);

  int insert(User record);

  int insertSelective(User record);

  User selectByPrimaryKey(Long id);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);

  User checkLogin(String username, String password);

  User selectByUsername(String username);
}