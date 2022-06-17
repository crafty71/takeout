package com.crafty.takeout.service.impl;

import com.crafty.takeout.common.Constant;
import com.crafty.takeout.exception.ImoocMallException;
import com.crafty.takeout.exception.ImoocMallExceptionEnum;
import com.crafty.takeout.model.dao.CategoryMapper;
import com.crafty.takeout.model.pojo.Category;
import com.crafty.takeout.model.pojo.Employee;
import com.crafty.takeout.model.request.CategoryAddReq;
import com.crafty.takeout.service.AdminCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {

  @Resource
  CategoryMapper categoryMapper;

  @Override
  public PageInfo<?> selectAllCategory(Integer pageNum, Integer pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Category> categoryList = categoryMapper.selectAllCategory();
    return new PageInfo<>(categoryList);
  }

  @Override
  public Category addNewCategory(CategoryAddReq category, HttpSession session) {
    Category categoryOne = new Category();
    Category categoryTwo = categoryMapper.selectByPrimaryKey(category.getId());
    if (categoryTwo != null) {
      throw new ImoocMallException(ImoocMallExceptionEnum.CATEGORY_EXIST);
    }
    Category CategorySelectByName = categoryMapper.selectByName(category.getName());
    if (CategorySelectByName != null) {
      throw new ImoocMallException(ImoocMallExceptionEnum.CATEGORY_NAME_UNIQUE);
    }
    categoryOne.setId(category.getId());
    categoryOne.setType(category.getType());
    categoryOne.setName(category.getName());
    categoryOne.setCreateTime(new Date());
    categoryOne.setUpdateTime(new Date());
    categoryOne.setSort(category.getSort());
    Employee attribute = (Employee) session.getAttribute(Constant.USER);
    categoryOne.setCreateUser(Long.valueOf(attribute.getId()));
    categoryOne.setUpdateUser(Long.valueOf(attribute.getId()));
    int count = categoryMapper.insert(categoryOne);
    if (count != 1) {
      throw new ImoocMallException(ImoocMallExceptionEnum.UPDATE_FAILED);
    }
    return categoryMapper.selectByPrimaryKey(categoryOne.getId());
  }

  @Override
  public Category updateCategoryById(CategoryAddReq category, HttpSession session) {
    Category categoryOne = categoryMapper.selectByPrimaryKey(category.getId());
    categoryOne.setId(category.getId());
    categoryOne.setType(category.getType());
    categoryOne.setName(category.getName());
    categoryOne.setUpdateTime(new Date());
    categoryOne.setSort(category.getSort());
    Employee attribute = (Employee) session.getAttribute(Constant.USER);
    categoryOne.setUpdateUser(Long.valueOf(attribute.getId()));
    int count = categoryMapper.updateByPrimaryKeySelective(categoryOne);
    if (count != 1) {
      throw new ImoocMallException(ImoocMallExceptionEnum.UPDATE_FAILED);
    }
    return categoryMapper.selectByPrimaryKey(category.getId());
  }

  @Override
  public void deleteCategoryById(Long id) {
    Category category = categoryMapper.selectByPrimaryKey(id);
    if (category == null) {
      throw new ImoocMallException(ImoocMallExceptionEnum.CATEGORY_NOT_EXIST);
    }
    int count = categoryMapper.deleteByPrimaryKey(id);
    if (count != 1) {
      throw new ImoocMallException(ImoocMallExceptionEnum.UPDATE_FAILED);
    }
  }

  @Override
  public Category selectCategoryById(Long id) {
    Category category = categoryMapper.selectByPrimaryKey(id);
    if(category == null) {
      throw  new ImoocMallException(ImoocMallExceptionEnum.CATEGORY_NOT_EXIST);
    }
    return category;
  }
}
