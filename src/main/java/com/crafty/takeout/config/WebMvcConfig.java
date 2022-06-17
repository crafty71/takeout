package com.crafty.takeout.config;

import com.crafty.takeout.common.Constant;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 描述：     配置地址映射
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("file:" + Constant.FILE_UPLOAD_DIR)
        .addResourceLocations(Constant.FILE_UPLOAD_DIR);
    registry.addResourceHandler("swagger-ui.html").addResourceLocations(
        "classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**").addResourceLocations(
        "classpath:/META-INF/resources/webjars/");
  }
}