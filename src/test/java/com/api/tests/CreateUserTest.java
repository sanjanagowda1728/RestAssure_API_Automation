package com.api.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.base.BaseTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateUserTest extends BaseTest {
@Test(priority = 1)
public void testCreateUser() {
    String requestBody = "{\"name\": \"John Doe\", \"job\": \"Software Engineer\"}";

    Response response = given()
            .header("Content-Type", "application/json")
            .body(requestBody)
    .when()
            .post("/users")
    .then()
            .statusCode(201)
            .body("name", equalTo("John Doe"))
            .body("job", equalTo("Software Engineer"))
            .extract().response();
    
    int userId = response.jsonPath().getInt("id");
    System.out.println("User created with ID: " + userId);
}
}
