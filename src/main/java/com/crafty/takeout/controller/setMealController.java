package com.crafty.takeout.controller;


import com.crafty.takeout.common.ApiRestResponse;
import com.crafty.takeout.model.pojo.SetMealDish;
import com.crafty.takeout.service.SetMealService;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 套餐管理
 */
@RestController
public class setMealController {

  @Resource
  SetMealService setMealService;

  /*
   * 套餐分页查询
   * @param page
   * @param pageSize
   * @param name
   * @return
   */

  @GetMapping("/selectAllSetMeal")
  public ApiRestResponse<PageInfo<SetMealDish>> selectAllSetMeal(@RequestParam Integer pageNum,
      @RequestParam Integer pageSize) {
    PageInfo<SetMealDish> pageInfo = setMealService.selectAllSetMeal(pageNum, pageSize);
    return ApiRestResponse.success(pageInfo);
  }
}
