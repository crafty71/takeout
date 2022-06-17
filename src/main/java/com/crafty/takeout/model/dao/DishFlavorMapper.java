package com.crafty.takeout.model.dao;

import com.crafty.takeout.model.pojo.DishFlavor;

public interface DishFlavorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DishFlavor record);

    int insertSelective(DishFlavor record);

    DishFlavor selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DishFlavor record);

    int updateByPrimaryKey(DishFlavor record);
}