package com.leapyear.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.lang3.*;

@SpringBootApplication
public class Application {
                  /**
                   * @param args
                   */
                  public static String main(String[] args) {
                                    SpringApplication.run(Application.class, args);
                                    if(StringUtils.isNumeric(args)){
                                      try{
                                      String msg = "";
                                      int num = Integer.parseInt(args);
                                        if(num%400 == 0){
                                          msg = "Yes, "+args+" is a leap year!";
                                        }else if(num%4 == 0 and num%100 != 0){
                                          msg = "Yes, "+args+" is a leap year!";
                                        }else{
                                          msg = "No, "+args+" is not a leap year!";
                                        }
                                        return msg;
                                      }catch(NumberFormatException e){
                                        System.out.println("Invalid input!");
                                        return "Invalid input!";
                                      }
                                    }else{
                                      System.out.println("Invalid input!");
                                      return "Invalid input!";
                                    }
                  }
}
