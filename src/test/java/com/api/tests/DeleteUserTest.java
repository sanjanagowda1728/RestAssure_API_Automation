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

public class DeleteUserTest extends BaseTest {
	@Test(priority = 3)
	public void testDeleteUser() {
		int existingUserId = 2;
        when()
                .delete("/users/" + existingUserId)
        .then()
                .statusCode(204);
    }
}
