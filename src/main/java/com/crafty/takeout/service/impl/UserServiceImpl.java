package com.crafty.takeout.service.impl;

import com.crafty.takeout.exception.ImoocMallException;
import com.crafty.takeout.exception.ImoocMallExceptionEnum;
import com.crafty.takeout.model.dao.CategoryMapper;
import com.crafty.takeout.model.dao.UserMapper;
import com.crafty.takeout.model.pojo.Category;
import com.crafty.takeout.model.pojo.User;
import com.crafty.takeout.model.request.UserCreate;
import com.crafty.takeout.service.UserService;
import com.crafty.takeout.utils.MD5Utils;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Resource
  CategoryMapper categoryMapper;

  @Resource
  UserMapper userMapper;

  @Override
  public Category test(Long id) {
    return categoryMapper.selectByPrimaryKey(id);
  }

  @Override
  public User checkLogin(UserCreate userCreate) throws NoSuchAlgorithmException {
    User userOne = new User();
    User user = userMapper.selectByUsername(userCreate.getName());
    if (user != null) {
      throw new ImoocMallException(ImoocMallExceptionEnum.USER_NAME_EXIST);
    }
    userOne.setName(userCreate.getName());
    userOne.setPhone(userCreate.getPhone());
    userOne.setSex(userCreate.getSex());
    userOne.setIdNumber(userCreate.getIdNumber());
    userOne.setAvatar(userCreate.getAvatar());
    userOne.setStatus(1);
    String password = MD5Utils.getMD5Str(userCreate.getPassword());
    userOne.setPassword(password);
    System.out.println(userOne);
    int count = userMapper.insert(userOne);
    if (count != 1) {
      throw new ImoocMallException(ImoocMallExceptionEnum.UPDATE_FAILED);
    }
    return userMapper.selectByPrimaryKey(userOne.getId());
  }

  @Override
  public void loginWithName(String username, String password) throws NoSuchAlgorithmException {
    User user = userMapper.checkLogin(username, MD5Utils.getMD5Str(password));
    if (user == null) {
      throw new ImoocMallException(ImoocMallExceptionEnum.WRONG_PASSWORD);
    }

  }


}
