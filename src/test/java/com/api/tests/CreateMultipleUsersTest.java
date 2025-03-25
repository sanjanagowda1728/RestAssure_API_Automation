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

public class CreateMultipleUsersTest extends BaseTest {
	@Test(priority = 3)
	public void testCreateMultipleUsers() {
	    String requestBody = "[{\"name\": \"John Doe\", \"job\": \"Software Engineer\"}, " +
	                         "{\"name\": \"Jane Doe\", \"job\": \"QA Engineer\"}]";

	    Response response = given()
	            .header("Content-Type", "application/json")
	            .body(requestBody)
	    .when()
	            .post("/users")
	    .then()
	            .statusCode(201)
	            .extract().response();
	    System.out.println("Create Users Response: " + response.asString());
	}

}
