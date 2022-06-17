package com.crafty.takeout.controller;

import com.crafty.takeout.common.ApiRestResponse;
import com.crafty.takeout.model.request.DishWithFlo;
import com.crafty.takeout.service.DishService;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dish")
public class DishController {

  @Resource
  DishService dishService;

  /*
   * 菜品信息分页查询
   * @param page
   * @param pageSize
   * @param name
   * @return
   */
  @RequestMapping("/list")
  public ApiRestResponse<PageInfo<?>> getDishList(@RequestParam Integer pageNum,
      @RequestParam Integer pageSize) {
    PageInfo<?> dishPageInfo = dishService.selectAllDish(pageNum, pageSize);
    return ApiRestResponse.success(dishPageInfo);
  }

  /*
   * 根据id查询菜品信息和对应的口味信息
   * @param id
   * @return
   */
  @GetMapping("/ListWithFlo")
  public ApiRestResponse<DishWithFlo> getDishListById(@RequestParam Long id) {
    DishWithFlo disInfo = dishService.selectDishById(id);
    return ApiRestResponse.success(disInfo);
  }
}
