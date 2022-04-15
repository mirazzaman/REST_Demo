package com.mz.RestAssuredSuit;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


/*
Possible operation for POST method
	Add a record in customers
	Add a record in EmployeeDetails
	Add a record in City

 * 
 * */
public class Post_Operation {
	

	
//Add a record in EmployeeDetails
	@Test
	public void Add_a_record_in_EmployeeDetails() {
		System.out.println("================================== POST REQUEST =========================================");
		System.out.println("Add a Record in EmployeeDetails");
		
		HashMap data = new HashMap();
		data.put("lastName", "Amel");
		data.put("firstName", "Boucetta");
		data.put("email", "amelBoucetta@mzllc.com");
		data.put("jobTitle", "Manager"); 
		
		Response resp = 
				// yor resources
				given().	
					contentType("application/json").
					contentType(ContentType.JSON).
					body(data).
				// your operation to be performed
				when().
					post("http://localhost:3000/EmployeeDetails").
				// your Validation	
				then().
					statusCode(201).
					log().all().
					extract().response();
			String jsonString = resp.asPrettyString();
			int statusCode = resp.getStatusCode();
			Assert.assertEquals(statusCode, 201);
			System.out.println("Rrecord insterted successfully"+data.toString());

		}
	
	//Add a record in customers
	@Test
	public void Add_a_record_in_customers() {
		System.out.println("================================== POST REQUEST =========================================");
		System.out.println("Add a Record in customers");
		
		HashMap data = new HashMap();
		data.put("name", "Sarah");
		data.put("city", "FL");

		Response resp = 
				// yor resources
				given().	
					contentType("application/json").
					contentType(ContentType.JSON).
					body(data).
				// your operation to be performed
				when().
					post("http://localhost:3000/Customers").
				// your Validation	
				then().
					statusCode(201).
					log().all().
					extract().response();
			String jsonString = resp.asPrettyString();
			int statusCode = resp.getStatusCode();
			Assert.assertEquals(statusCode, 201);
			System.out.println("Rrecord insterted successfully"+data);
		
	}
	
	//Add a record in City
	@Test
	public void Add_a_record_in_City() {
		System.out.println("================================== POST REQUEST =========================================");
		System.out.println("Add a Record in City");
		
		HashMap data = new HashMap();
		data.put("city", "Reston");

		Response resp = 
				// yor resources
				given().	
					contentType("application/json").
					contentType(ContentType.JSON).
					body(data).
				// your operation to be performed
				when().
					post("http://localhost:3000/City").
				// your Validation	
				then().
					statusCode(201).
					log().all().
					extract().response();
			String jsonString = resp.asPrettyString();
			int statusCode = resp.getStatusCode();
			Assert.assertEquals(statusCode, 201);
			System.out.println("Rrecord insterted successfully"+data);
		
	}
	}

