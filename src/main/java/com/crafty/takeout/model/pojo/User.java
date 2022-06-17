package com.crafty.takeout.model.pojo;

public class User {

  private Long id;

  private String name;

  private String phone;

  private String sex;

  private String idNumber;

  private String avatar;

  private Integer status;

  private String password;

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
    this.name = name == null ? null : name.trim();
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone == null ? null : phone.trim();
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex == null ? null : sex.trim();
  }

  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber == null ? null : idNumber.trim();
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar == null ? null : avatar.trim();
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}