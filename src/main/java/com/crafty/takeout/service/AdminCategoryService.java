package com.crafty.takeout.service;

import com.crafty.takeout.model.pojo.Category;
import com.crafty.takeout.model.request.CategoryAddReq;
import com.github.pagehelper.PageInfo;
import javax.servlet.http.HttpSession;

public interface AdminCategoryService {

  PageInfo<?> selectAllCategory(Integer pageNum, Integer pageSize);

  Category addNewCategory(CategoryAddReq category, HttpSession session);

  Category updateCategoryById(CategoryAddReq category, HttpSession session);

  void deleteCategoryById(Long id);

  Category selectCategoryById(Long id);
}
