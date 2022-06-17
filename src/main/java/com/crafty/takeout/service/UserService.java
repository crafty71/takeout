package com.crafty.takeout.service;

import com.crafty.takeout.model.pojo.Category;
import com.crafty.takeout.model.pojo.User;
import com.crafty.takeout.model.request.UserCreate;
import java.security.NoSuchAlgorithmException;

public interface UserService {

  Category test(Long id);

  User checkLogin(UserCreate userCreate) throws NoSuchAlgorithmException;

  void loginWithName(String username, String password) throws NoSuchAlgorithmException;
}
