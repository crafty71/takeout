package com.crafty.takeout.controller;

import com.crafty.takeout.common.ApiRestResponse;
import com.crafty.takeout.common.Constant;
import com.crafty.takeout.exception.ImoocMallException;
import com.crafty.takeout.exception.ImoocMallExceptionEnum;
import com.crafty.takeout.model.pojo.Employee;
import com.crafty.takeout.model.request.EmployeeReq;
import com.crafty.takeout.service.EmployeeService;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  @Resource
  EmployeeService employeeService;


  /**
   * 员工登录
   *
   * @return ApiRestResponse
   */
  @PostMapping("/login")
  public ApiRestResponse<Employee> login(@RequestParam("userName") String userName,
      @RequestParam("password") String password, HttpSession session)
      throws NoSuchAlgorithmException {
    if (StringUtils.isEmpty(userName)) {
      throw new ImoocMallException(ImoocMallExceptionEnum.NEED_USER_NAME);
    }
    if (StringUtils.isEmpty(password)) {
      throw new ImoocMallException(ImoocMallExceptionEnum.NEED_PASSWORD);
    }
    Employee register = employeeService.register(userName, password);
    register.setPassword(null);
    session.setAttribute(Constant.USER, register);
    return ApiRestResponse.success(register);
  }

  /**
   * 根据id修改员工信息
   *
   * @return ApiRestResponse
   */
  @PutMapping("/user/update")
  public ApiRestResponse<Employee> update(HttpSession session, @RequestBody EmployeeReq employee) {

    Employee employeeOld = new Employee();
    BeanUtils.copyProperties(employee, employeeOld);
    Employee employeeNew = employeeService.updateById(session, employeeOld);
    return ApiRestResponse.success(employeeNew);
  }

  /**
   * 员工退出
   *
   * @return ApiRestResponse
   */
  @PostMapping("/logout")
  public ApiRestResponse<Map<String, String>> logout(HttpSession session) {
    session.removeAttribute(Constant.USER);
    HashMap<String, String> map = new HashMap<>();
    map.put("msg", "退出登录成功");
    map.put("notice", "你好像瘦了，头发也变长，背影陌生到让我觉得，见你是上个世纪的事，然后你开口叫我名字，我就想笑，好像自己刚刚放学，只在校门口等了你五分钟而已");
    return ApiRestResponse.success(map);
  }

}
