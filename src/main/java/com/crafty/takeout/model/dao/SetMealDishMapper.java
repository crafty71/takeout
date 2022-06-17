package com.crafty.takeout.model.dao;

import com.crafty.takeout.model.pojo.SetMealDish;
import java.util.List;

public interface SetMealDishMapper {

  int deleteByPrimaryKey(Long id);

  int insert(SetMealDish record);

  int insertSelective(SetMealDish record);

  SetMealDish selectByPrimaryKey(Long id);

  int updateByPrimaryKeySelective(SetMealDish record);

  int updateByPrimaryKey(SetMealDish record);

  List<SetMealDish> selectAllAetMeal();
}