package com.api.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.base.BaseTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UpdateUserTest extends BaseTest {
	@Test(priority = 3)
    public void TestUpdateUser() {
        String requestBody = "{\"name\": \"Jane Doe\", \"job\": \"QA Engineer\"}";
        int UserId = 2;
        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
        .when()
                .put("/users/" + UserId)
        .then()
                .statusCode(200)
                .body("name", equalTo("Jane Doe"))
                .body("job", equalTo("QA Engineer"));
    }
}
