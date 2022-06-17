package com.crafty.takeout.model.dao;

import com.crafty.takeout.model.pojo.SetMeal;

public interface SetMealMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SetMeal record);

    int insertSelective(SetMeal record);

    SetMeal selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SetMeal record);

    int updateByPrimaryKey(SetMeal record);
}