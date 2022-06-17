package com.crafty.takeout.model.request;

import com.crafty.takeout.model.pojo.DishFlavor;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class DishWithFlo {

  private Long id;

  private String name;

  private Long categoryId;

  private BigDecimal price;

  private String code;

  private String image;

  private String description;

  private Integer status;

  private Integer sort;

  private Date createTime;

  private Date updateTime;

  private Long createUser;

  private Long updateUser;

  private Integer isDeleted;

  private List<DishFlavor> DishFlavorList;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getSort() {
    return sort;
  }

  public void setSort(Integer sort) {
    this.sort = sort;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Long getCreateUser() {
    return createUser;
  }

  public void setCreateUser(Long createUser) {
    this.createUser = createUser;
  }

  public Long getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(Long updateUser) {
    this.updateUser = updateUser;
  }

  public Integer getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(Integer isDeleted) {
    this.isDeleted = isDeleted;
  }

  public List<DishFlavor> getDishFlavorList() {
    return DishFlavorList;
  }

  public void setDishFlavorList(List<DishFlavor> dishFlavorList) {
    DishFlavorList = dishFlavorList;
  }
}
