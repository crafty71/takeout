package com.crafty.takeout.model.request;

public class UserCreate {


  private String name;

  private String phone;

  private String sex;

  private String idNumber;

  private String avatar;

  private String password;




  @Override
  public String toString() {
    return "UserCreate{" +
        "name='" + name + '\'' +
        ", phone='" + phone + '\'' +
        ", sex='" + sex + '\'' +
        ", idNumber='" + idNumber + '\'' +
        ", avatar='" + avatar + '\'' +
        ", password='" + password + '\'' +
        '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
