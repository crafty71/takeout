package com.crafty.takeout.service;

import com.crafty.takeout.model.pojo.Employee;
import com.crafty.takeout.model.request.EmployeeReq;
import com.github.pagehelper.PageInfo;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpSession;

public interface EmployeeService {

  Employee register(String username, String password) throws NoSuchAlgorithmException;

  boolean checkAdminRole(Employee currentUser);


  Employee createEmployee(EmployeeReq employee,
      HttpSession session) throws NoSuchAlgorithmException;

  PageInfo<?> getEmployeeList(Integer pageNum, Integer pageSize);

  Employee updateById(HttpSession session, Employee employee);

  Employee updateByIdForAdmin(Employee employee);

  Employee selectById(Long id);
}
