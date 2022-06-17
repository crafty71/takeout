package com.crafty.takeout.service.impl;

import com.crafty.takeout.model.dao.SetMealDishMapper;
import com.crafty.takeout.model.pojo.SetMealDish;
import com.crafty.takeout.service.SetMealService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SetMealServiceImpl implements SetMealService {

  @Resource
  SetMealDishMapper setMealDishMapper;

  @Override
  public PageInfo<SetMealDish> selectAllSetMeal(Integer pageNum, Integer pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<SetMealDish> setMealDishes = setMealDishMapper.selectAllAetMeal();
    return new PageInfo<>(setMealDishes);
  }
}
