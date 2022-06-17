package com.crafty.takeout.common;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 描述：     常量值
 */
@Component
public class Constant {

  public static final String SALT = "8svbsvjkweDF,.03[";
  public static final String  USER = "user";


  public static String FILE_UPLOAD_DIR;
  public static String ICODE;

  @Value("${file.upload.dir}")
  public void setFileUploadDir(String fileUploadDir) {
    FILE_UPLOAD_DIR = fileUploadDir;
  }

  @Value("${icode}")
  public void setICODE(String icode) {
    ICODE = icode;
  }
}
