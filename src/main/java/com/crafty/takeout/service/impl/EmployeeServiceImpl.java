package com.crafty.takeout.service.impl;

import com.crafty.takeout.common.Constant;
import com.crafty.takeout.exception.ImoocMallException;
import com.crafty.takeout.exception.ImoocMallExceptionEnum;
import com.crafty.takeout.model.dao.EmployeeMapper;
import com.crafty.takeout.model.pojo.Employee;
import com.crafty.takeout.model.request.EmployeeReq;
import com.crafty.takeout.service.EmployeeService;
import com.crafty.takeout.utils.MD5Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Resource
  EmployeeMapper employeeMapper;

  @Override
  public Employee register(String username, String password) throws NoSuchAlgorithmException {
    password = MD5Utils.getMD5Str(password);
    Employee employee = employeeMapper.selectLogin(username, password);
    if (employee == null) {
      throw new ImoocMallException(ImoocMallExceptionEnum.WRONG_PASSWORD);
    }

    if (employee.getStatus() == 0) {
      throw new ImoocMallException(ImoocMallExceptionEnum.NOT_ALLOW_LOGIN);
    }
    return employee;
  }

  @Override
  public boolean checkAdminRole(Employee currentUser) {
    Employee employee = employeeMapper.selectByPrimaryKey(Math.toIntExact(currentUser.getId()));
    return employee.getRoles() == 2;
  }

  @Override
  public Employee createEmployee(EmployeeReq employee, HttpSession session)
      throws NoSuchAlgorithmException {
    Employee employeeOld = new Employee();
    Employee employeeCheck = employeeMapper.selectByName(employee.getUsername());
    if (employeeCheck != null) {
      throw new ImoocMallException(ImoocMallExceptionEnum.NAME_EXISTED);
    }

    employeeOld.setName(employee.getName());
    employeeOld.setUsername(employee.getUsername());
    employeeOld.setPassword(MD5Utils.getMD5Str(employee.getPassword()));
    employeeOld.setPhone(employee.getPhone());
    employeeOld.setSex(employee.getSex());
    employeeOld.setStatus(employee.getStatus());
    employeeOld.setCreateTime(new Date());
    employeeOld.setCreateTime(new Date());
    employeeOld.setUpdateTime(new Date());
    employeeOld.setIdNumber(employee.getIdNumber());
    Employee attribute = (Employee) session.getAttribute(Constant.USER);
    employeeOld.setCreateUser(Long.valueOf(attribute.getId()));
    employeeOld.setUpdateUser(Long.valueOf(attribute.getId()));
    employeeOld.setRoles(1);
    int count = employeeMapper.insertSelective(employeeOld);
    if (count != 1) {
      throw new ImoocMallException(ImoocMallExceptionEnum.UPDATE_FAILED);
    }
    return employeeOld;
  }

  @Override
  public PageInfo<?> getEmployeeList(Integer pageNum, Integer pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Employee> list = employeeMapper.selectAllEmployee();
    return new PageInfo<>(list);
  }

  @Override
  public Employee updateById(HttpSession session, Employee employee) {
    Employee attribute = (Employee) session.getAttribute(Constant.USER);
    Employee employeeOne = employeeMapper.selectByName(employee.getUsername());
    if (!Objects.equals(attribute.getId(), employeeOne.getId())) {
      throw new ImoocMallException(ImoocMallExceptionEnum.NOT_YOUR_ORDER);
    }
    employee.setCreateTime(employeeOne.getCreateTime());
    employee.setUpdateTime(new Date());
    employee.setCreateUser(employeeOne.getCreateUser());
    employee.setUpdateUser(employeeOne.getUpdateUser());
    employee.setRoles(employeeOne.getRoles());
    employee.setId(Math.toIntExact(employeeOne.getId()));
    int count = employeeMapper.updateByPrimaryKey(employee);
    System.out.println(count);
    if (count == 0) {
      throw new ImoocMallException(ImoocMallExceptionEnum.UPDATE_FAILED);
    }
    return employeeMapper.selectByPrimaryKey(Math.toIntExact(attribute.getId()));
  }

  @Override
  public Employee updateByIdForAdmin(Employee employee) {
    Employee employeeOld = employeeMapper.selectByPrimaryKey(Math.toIntExact(employee.getId()));
    employee.setCreateTime(employeeOld.getCreateTime());
    employee.setUpdateTime(new Date());
    employee.setCreateUser(employeeOld.getCreateUser());
    employee.setUpdateUser(employeeOld.getUpdateUser());
    employee.setRoles(employeeOld.getRoles());
    int count = employeeMapper.updateByPrimaryKey(employee);
    if (count == 0) {
      throw new ImoocMallException(ImoocMallExceptionEnum.UPDATE_FAILED);
    }
    return employeeMapper.selectByPrimaryKey(Math.toIntExact(employee.getId()));
  }

  @Override
  public Employee selectById(Long id) {
    Employee employee = employeeMapper.selectByPrimaryKey(Math.toIntExact(id));
    if (employee == null) {
      throw new ImoocMallException(ImoocMallExceptionEnum.NOT_EXIST_EMPLOYEE);
    }
    return employee;
  }
}
