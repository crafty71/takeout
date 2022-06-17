package com.crafty.takeout.filter;

import com.crafty.takeout.common.Constant;
import com.crafty.takeout.model.pojo.Employee;
import com.crafty.takeout.service.EmployeeService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;


/**
 * 描述：     用户过滤器
 */
public class UserFilter implements Filter {

  public static Employee employee;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpSession session = request.getSession();
    employee = (Employee) session.getAttribute(Constant.USER);
    if (employee == null) {
      PrintWriter out = new HttpServletResponseWrapper(
          (HttpServletResponse) servletResponse).getWriter();
      out.write("{\n"
          + "    \"status\": 10007,\n"
          + "    \"msg\": \"NEED_LOGIN\",\n"
          + "    \"data\": null\n"
          + "}");
      out.flush();
      out.close();
      return;
    }
    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {

  }
}
