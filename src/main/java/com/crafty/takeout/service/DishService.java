package com.crafty.takeout.service;

import com.crafty.takeout.model.pojo.Dish;
import com.crafty.takeout.model.request.DishAddReq;
import com.crafty.takeout.model.request.DishWithFlo;
import com.github.pagehelper.PageInfo;
import javax.servlet.http.HttpSession;

public interface DishService {

  PageInfo<Dish> selectAllDish(Integer pageNum, Integer pageSize);

  Dish addNewDish(DishAddReq dish, HttpSession session);

  DishWithFlo selectDishById(Long id);

  Dish updateById(DishAddReq dishAddReq);


  void deleteById(Long id);
}
