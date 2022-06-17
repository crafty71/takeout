package com.crafty.takeout.model.request;

public class CategoryAddReq {

  private Long id;

  private Integer type;

  private String name;

  private Integer sort;


  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getSort() {
    return sort;
  }

  public void setSort(Integer sort) {
    this.sort = sort;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "CategoryAddReq{" +
        "id=" + id +
        ", type=" + type +
        ", name='" + name + '\'' +
        ", sort=" + sort +
        '}';
  }
}