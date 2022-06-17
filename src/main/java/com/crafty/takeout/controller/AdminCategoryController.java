package com.crafty.takeout.controller;

import com.crafty.takeout.common.ApiRestResponse;
import com.crafty.takeout.model.pojo.Category;
import com.crafty.takeout.model.request.CategoryAddReq;
import com.crafty.takeout.service.AdminCategoryService;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin/category")
public class AdminCategoryController {

  @Resource
  AdminCategoryService adminCategoryService;

  /*
   * 获取分页列表
   * @param pageNum
   * @param pageSize
   * @return  ApiRestResponse<PageInfo<?>>
   */
  @GetMapping("/list")
  public ApiRestResponse<PageInfo<?>> getCategoryList(@RequestParam Integer pageNum,
      @RequestParam Integer pageSize) {
    PageInfo<?> categoryList = adminCategoryService.selectAllCategory(pageNum, pageSize);
    return ApiRestResponse.success(categoryList);
  }

  /*
   * 新增分类
   * @param category
   * @return
   */
  @PostMapping("/add")
  public ApiRestResponse<Category> addCategory(@RequestBody CategoryAddReq category,
      HttpSession session) {
    System.out.println(category);
    Category categoryNew = adminCategoryService.addNewCategory(category, session);
    return ApiRestResponse.success(categoryNew);
  }


  /*
   * 根据id修改分类信息
   * @param category
   * @return ApiRestResponse<Category>
   */
  @PutMapping("/update")
  public ApiRestResponse<Category> updateCategory(@RequestBody CategoryAddReq category,
      HttpSession session) {
    Category categoryNew = adminCategoryService.updateCategoryById(category, session);
    return ApiRestResponse.success(categoryNew);
  }

  /*
   * 根据id删除分类
   * @param id
   * @return
   */
  @DeleteMapping("/delete")
  public ApiRestResponse<?> deleteCategory(@RequestParam Long Id) {
    adminCategoryService.deleteCategoryById(Id);
    return ApiRestResponse.success();
  }

  /*
   * 根据ID数据
   * @param category
   * @return
   */
  @GetMapping("/getCategoryById")
  public ApiRestResponse<Category> selectCategoryById(@RequestParam Long Id) {
    Category category = adminCategoryService.selectCategoryById(Id);
    return ApiRestResponse.success(category);
  }

//  /*
//   * 根据条件查询分类数据
//   * @param category
//   * @return
//   */
//   public ApiRestResponse<Category>  selectCategorySort(){
//     return  null;
//   }
}
