package com.crafty.takeout.model.dao;

import com.crafty.takeout.model.pojo.Dish;
import com.crafty.takeout.model.pojo.DishFlavor;
import com.crafty.takeout.model.request.DishWithFlo;
import java.util.ArrayList;
import java.util.List;

public interface DishMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Dish record);

    int insertSelective(Dish record);

    Dish selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dish record);

    int updateByPrimaryKey(Dish record);

  List<Dish>  selectAll();


  Dish selectByName (String name);

  DishWithFlo selectByIdWithFlovr (Long id);

  ArrayList<DishFlavor>  selectByIdWithFlovrs(Long id);
}