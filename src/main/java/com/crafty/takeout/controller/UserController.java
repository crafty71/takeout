package com.crafty.takeout.controller;

import com.crafty.takeout.common.ApiRestResponse;
import com.crafty.takeout.model.pojo.Category;
import com.crafty.takeout.model.pojo.User;
import com.crafty.takeout.model.request.UserCreate;
import com.crafty.takeout.service.UserService;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Resource
  UserService userService;

  @GetMapping("/test")
  public ApiRestResponse<Category> test(@RequestParam("id") Long id) {
    Category category = userService.test(id);
    return ApiRestResponse.success(category);
  }

  /*
   * 移动端用户注册
   * @param map
   * @param session
   * @return
   */
  @PostMapping("/createUser")
  public ApiRestResponse<User> createUser(@RequestBody UserCreate user)
      throws NoSuchAlgorithmException {
    User userOne = userService.checkLogin(user);
    return ApiRestResponse.success(userOne);
  }
  /*
   * 移动端用户登录
   * @param map
   * @param session
   * @return
   */

  @PostMapping("/userLogin")
  public ApiRestResponse<?> userLogin(@RequestParam String username,
      @RequestParam String password) throws NoSuchAlgorithmException {
    userService.loginWithName(username, password);
    return ApiRestResponse.success();
  }
}
