
package com.leapyear.springboot.controller;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.swathisprasad.springboot.Application;
import com.jayway.restassured.RestAssured;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(classes = Application.class) 
@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringRestControllerTest {
    @Value("${server.port}") 
    int port;
       @Test
       public void getDataTest() {
              get("/api/tdd/responseData").then().assertThat().body("data", equalTo("Invalid input!"));
              get("/api/tdd/2.55").then().assertThat().body("data", equalTo("Invalid input!"));
              get("/api/tdd/!:").then().assertThat().body("data", equalTo("Invalid input!"));
              get("/api/tdd/1").then().assertThat().body("data", equalTo("No, 1 is not a leap year!"));
              get("/api/tdd/13").then().assertThat().body("data", equalTo("No, 13 is not a leap year!"));
              get("/api/tdd/130").then().assertThat().body("data", equalTo("No, 130 is not a leap year!"));
              get("/api/tdd/1300").then().assertThat().body("data", equalTo("No, 1300 is not a leap year!"));
              get("/api/tdd/1900").then().assertThat().body("data", equalTo("No, 1900 is not a leap year!"));
              get("/api/tdd/1901").then().assertThat().body("data", equalTo("No, 1901 is not a leap year!"));
              get("/api/tdd/4").then().assertThat().body("data", equalTo("Yes, 4 is a leap year!"));
              get("/api/tdd/16").then().assertThat().body("data", equalTo("Yes, 16 is a leap year!"));
              get("/api/tdd/800").then().assertThat().body("data", equalTo("Yes, 800 is a leap year!"));
              get("/api/tdd/840").then().assertThat().body("data", equalTo("Yes, 840 is a leap year!"));
              get("/api/tdd/1904").then().assertThat().body("data", equalTo("Yes, 1904 is a leap year!"));
              get("/api/tdd/2004").then().assertThat().body("data", equalTo("Yes, 2004 is a leap year!"));
              get("/api/tdd/2400").then().assertThat().body("data", equalTo("Yes, 2400 is a leap year!"));
       }
       @Before
       public void setBaseUri () {
               RestAssured.port = 8080;
               RestAssured.baseURI = "http://localhost"; 
       }
}
