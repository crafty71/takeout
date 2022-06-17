package com.crafty.takeout.model.dao;

import com.crafty.takeout.model.pojo.Employee;
import java.util.List;

public interface EmployeeMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(Employee record);

  int insertSelective(Employee record);

  Employee selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Employee record);

  int updateByPrimaryKey(Employee record);

  List<Employee> selectAllEmployee();

  Employee selectByName(String username);

  Employee selectLogin(String username, String password);
}