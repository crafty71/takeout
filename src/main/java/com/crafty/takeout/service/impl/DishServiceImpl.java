package com.crafty.takeout.service.impl;

import com.crafty.takeout.common.Constant;
import com.crafty.takeout.exception.ImoocMallException;
import com.crafty.takeout.exception.ImoocMallExceptionEnum;
import com.crafty.takeout.model.dao.DishMapper;
import com.crafty.takeout.model.pojo.Dish;
import com.crafty.takeout.model.pojo.DishFlavor;
import com.crafty.takeout.model.pojo.Employee;
import com.crafty.takeout.model.request.DishAddReq;
import com.crafty.takeout.model.request.DishWithFlo;
import com.crafty.takeout.service.DishService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl implements DishService {

  @Resource
  DishMapper dishMapper;

  @Override
  public PageInfo<Dish> selectAllDish(Integer pageNum, Integer pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Dish> dishList = dishMapper.selectAll();
    return new PageInfo<>(dishList);
  }

  @Override
  public Dish addNewDish(DishAddReq dish, HttpSession session) {
    Dish dishNew = new Dish();
    if (dishMapper.selectByPrimaryKey(dish.getId()) != null) {
      throw new ImoocMallException(ImoocMallExceptionEnum.ID_EXIST);
    }
    if (dishMapper.selectByName(dish.getName()) != null) {
      throw new ImoocMallException(ImoocMallExceptionEnum.NAME_EXISTED);
    }
    dishNew.setId(dish.getId());
    dishNew.setName(dish.getName());
    dishNew.setCategoryId(dish.getCategoryId());
    dishNew.setPrice(dish.getPrice());
    dishNew.setCode(dish.getCode());
    dishNew.setDescription(dish.getDescription());
    dishNew.setStatus(dish.getStatus());
    dishNew.setSort(dish.getSort());
    dishNew.setImage(dish.getImage());
    dishNew.setCreateTime(new Date());
    dishNew.setUpdateTime(new Date());
    Employee attribute = (Employee) session.getAttribute(Constant.USER);
    dishNew.setCreateUser(Long.valueOf(attribute.getId()));
    dishNew.setUpdateUser(Long.valueOf(attribute.getId()));
    dishNew.setIsDeleted(0);
    int count = dishMapper.insertSelective(dishNew);
    if (count != 1) {
      throw new ImoocMallException(ImoocMallExceptionEnum.UPDATE_FAILED);
    }
    return dishMapper.selectByPrimaryKey(dishNew.getId());
  }

  @Override
  public DishWithFlo selectDishById(Long id) {
    ArrayList<DishFlavor> dishFlavorArrayList = dishMapper.selectByIdWithFlovrs(id);
    Dish dish = dishMapper.selectByPrimaryKey(id);
    DishWithFlo dishWithFlo = new DishWithFlo();
    BeanUtils.copyProperties(dish, dishWithFlo);
    dishWithFlo.setDishFlavorList(dishFlavorArrayList);
    return dishWithFlo;
  }

  @Override
  public Dish updateById(DishAddReq dishAddReq) {
    Dish dish = new Dish();
    BeanUtils.copyProperties(dishAddReq, dish);
    int count = dishMapper.updateByPrimaryKeySelective(dish);
    if (count != 1) {
      throw new ImoocMallException(ImoocMallExceptionEnum.UPDATE_FAILED);
    }
    return dishMapper.selectByPrimaryKey(dish.getId());
  }

  @Override
  public void deleteById(Long id) {
    int count = dishMapper.deleteByPrimaryKey(id);
    if (count != 1) {
      throw new ImoocMallException(ImoocMallExceptionEnum.UPDATE_FAILED);
    }
  }
}
