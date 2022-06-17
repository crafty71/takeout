package com.crafty.takeout.controller;

import com.crafty.takeout.common.ApiRestResponse;
import com.crafty.takeout.model.pojo.Dish;
import com.crafty.takeout.model.request.DishAddReq;
import com.crafty.takeout.service.DishService;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/dish/")
public class AdminDishController {

  @Resource
  DishService dishService;

  /*
   * 新增菜品
   * @param dishDto
   * @return
   */

  @PutMapping("/addNew")
  public ApiRestResponse<Dish> updateDish(@RequestBody DishAddReq dish, HttpSession session) {
    Dish dishNew = dishService.addNewDish(dish, session);
    return ApiRestResponse.success(dishNew);
  }

  /*
   * 修改菜品
   * @param dishDto
   * @return
   */
  @PutMapping("/update")
  public ApiRestResponse<Dish> updateDish(@RequestBody DishAddReq dishAddReq) {
    Dish dish = dishService.updateById(dishAddReq);
    return ApiRestResponse.success(dish);
  }

  /*
   * 删除套餐
   * @param ids
   * @return
   */
@DeleteMapping("/delete")
  public ApiRestResponse<?> deleteDishById(Long id){
    dishService.deleteById(id);
    return ApiRestResponse.success();
  }
}
