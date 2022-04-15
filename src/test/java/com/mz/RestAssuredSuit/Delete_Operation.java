package com.mz.RestAssuredSuit;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Delete_Operation {
	// delete customer by id
	@Test
	public void delete_customer_by_id() {
		System.out.println("================================== GET REQUEST =========================================");
		System.out.println("Update a record in customers........");

		Response resp =

				given().when().delete("http://localhost:3000/Customers/111").
				then().
					statusCode(404).log().all()
					.extract().response();

		int codes = resp.getStatusCode();
		Assert.assertEquals(codes, 404, "Status Code is different");

	}

}
