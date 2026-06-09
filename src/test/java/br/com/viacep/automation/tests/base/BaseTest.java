package br.com.viacep.automation.tests.base;

import java.util.Collections;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class BaseTest {

    @BeforeSuite
    public void setupSuite(){
        RestAssured.baseURI = "https://viacep.com.br/ws";
    }

    @BeforeMethod
    public void setup(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @AfterSuite
    public void reset(){
         RestAssured.replaceFiltersWith(Collections.emptyList());
    }

}
