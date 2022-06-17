package com.crafty.takeout;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.crafty.takeout.model.dao")
public class TakeoutApplication {

  public static void main(String[] args) {
    SpringApplication.run(TakeoutApplication.class, args);
  }

}
