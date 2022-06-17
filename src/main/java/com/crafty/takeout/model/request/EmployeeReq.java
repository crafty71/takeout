package com.crafty.takeout.model.request;

import javax.validation.constraints.NotNull;

public class EmployeeReq {


  @NotNull(message = "name不能为null")
  private String name;
  @NotNull(message = "username不能为null")
  private String username;
  @NotNull(message = "password不能为null")
  private String password;
  @NotNull(message = "phone不能为null")
  private String phone;
  @NotNull(message = "sex不能为null")
  private String sex;
  @NotNull(message = "idNumber不能为null")
  private String idNumber;
  @NotNull(message = "status不能为null")
  private Integer status;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "EmployeeReq{" +
        "name='" + name + '\'' +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", phone='" + phone + '\'' +
        ", sex='" + sex + '\'' +
        ", idNumber='" + idNumber + '\'' +
        ", status=" + status +
        '}';
  }
}