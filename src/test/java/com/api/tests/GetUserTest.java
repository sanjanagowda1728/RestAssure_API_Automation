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

public class GetUserTest extends BaseTest {
	@Test(priority = 2)
	public void testGetUser() {
	    int existingUserId = 2;

	    given()
	    .when()
	            .get("/users/" + existingUserId)
	    .then()
	            .statusCode(200)
	            .body("data.id", equalTo(existingUserId));
	}
}
