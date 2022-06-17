package com.crafty.takeout.controller;

import com.crafty.takeout.common.ApiRestResponse;
import com.crafty.takeout.model.pojo.Employee;
import com.crafty.takeout.model.request.EmployeeAdminReq;
import com.crafty.takeout.model.request.EmployeeReq;
import com.crafty.takeout.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {


  @Resource
  EmployeeService employeeService;

  /**
   * 新增员工
   *
   * @return ApiRestResponse
   */
  @PostMapping("/createEmployee")
  public ApiRestResponse<Employee> save(HttpSession session,
      @Valid @RequestBody EmployeeReq employee)
      throws NoSuchAlgorithmException {
    Employee employeeNew = employeeService.createEmployee(employee, session);
    return ApiRestResponse.success(employeeNew);
  }

  /*
    员工信息分页查询
    @param page
   * @param pageSize
   * @param name
   * @return
   */

  @GetMapping("/page")
  public ApiRestResponse<PageInfo<?>> page(@RequestParam Integer pageNum,
      @RequestParam Integer pageSize) {
    PageInfo<?> employeeList = employeeService.getEmployeeList(pageNum, pageSize);
    return ApiRestResponse.success(employeeList);
  }


  /**
   * 根据id修改员工信息
   *
   * @return ApiRestResponse
   */
  @PutMapping("/user/update")
  public ApiRestResponse<Employee> update(@RequestBody EmployeeAdminReq employee) {
    Employee employeeOld = new Employee();
    BeanUtils.copyProperties(employee, employeeOld);
    Employee employeeOne = employeeService.updateByIdForAdmin(employeeOld);
    return ApiRestResponse.success(employeeOne);
  }

  /*
   * 根据id查询员工信息
   * @param id
   * @return
   */

  @GetMapping("/employeeDetail")
  public ApiRestResponse<Employee> selectEmployeeById(@RequestParam Long Id) {
    Employee employee = employeeService.selectById(Id);
    return ApiRestResponse.success(employee);
  }


}
