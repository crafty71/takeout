package com.crafty.takeout.service;

import com.crafty.takeout.model.pojo.SetMealDish;
import com.github.pagehelper.PageInfo;

public interface SetMealService {

  PageInfo<SetMealDish> selectAllSetMeal(Integer pageNum, Integer pageSize);
}
