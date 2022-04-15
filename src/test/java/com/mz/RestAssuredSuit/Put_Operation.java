package com.mz.RestAssuredSuit;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


//
//Possible operation for PUT method
//Update a record in customers
//Update a record in EmployeeDetails
//Update a record in City

public class Put_Operation {

	//Update a record in customers
	@Test
	public void update_a_record_in_customers() {
		System.out.println("================================== PUT REQUEST =========================================");
		System.out.println("Update a record in customers........");
		
		HashMap data = new HashMap();
		data.put("name", "Arif Khan");
		data.put("city", "Harandon");
		Response res = 
		given().
			contentType("application/json").
			contentType(ContentType.JSON).
			body(data).
		when().
			put("http://localhost:3000/Customers/108").
		then().
//			body("Customers[7].name", equalTo("Arif Khan")).
//			body("Customers[7].city", equalTo("Charlotte")).
			statusCode(200).
			log().all().
			extract().response();
		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.err.println("Status Code is '"+statusCode+"' and Passed");
	}
	
	

	
  //  "id": 107
	
	

}
