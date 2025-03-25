package com.api.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static String BASE_URI = "https://reqres.in/api";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URI;
        System.out.println("API Test Setup Completed. Base URI: " + BASE_URI);
    }
}
