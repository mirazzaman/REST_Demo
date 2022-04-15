package com.mz.RestAssuredSuit;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;;

/*
 *Possible operation for CustomersDetails using GET method
 *
	Sce_01: get all EmployeeDetails
	Sce_02: Search Employee by Job Title (vp sales)
	Sce_03: serch customers by city 
	Sce_04: get all city
	Sce_05: Search Employee by last Name 
	
	given, when, then, and , but  ===== REST BDD
	Given, When, Then, And, But   ===== BDD
 * */

public class Get_Operation {

	// Sce_01: get all EmployeeDetails
	@Test
	public void get_all_EmployeeDetails() {
		System.out.println("================================== GET REQUEST =========================================");
		System.out.println("Get all EmployeeDetails");

		Response resp = given().contentType("application/json").accept(ContentType.JSON).when()
				.get("http://localhost:3000/EmployeeDetails").then().statusCode(200).log().all().extract().response();
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Status Code is " + statusCode + " and Test is Passed!!!");
		System.out
				.println("\n=========================================================================================");

	}

	// Sce_02: Search Employee by Job Title (vp sales)
	@Test
	public void search_Employee_By_Job_Title() {
		System.out.println("================================== GET REQUEST =========================================");
		System.out.println("Search Employee by Job Title (vp sales)");
		Response resp = given().contentType("application/json").accept(ContentType.JSON).when()
				.get("http://localhost:3000/EmployeeDetails?jobTitle=Manager&id=1062").then().statusCode(200).log().all()
				.extract().response();
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Status Code is " + statusCode + " and Test is Passed!!!");
		System.out
				.println("\n=========================================================================================");

	}
	// Sce_05: Search Employee by last Name 
		@Test
		public void search_City() {
			System.out.println("================================== GET REQUEST =========================================");
			System.out.println("Search City by name");
			Response resp = given().contentType("application/json").accept(ContentType.JSON).when()
					.get("http://localhost:3000/City?city=Reston").then().statusCode(200).log().all()
					.extract().response();
			int statusCode = resp.getStatusCode();
			Assert.assertEquals(statusCode, 200);
			System.err.println("New city is Iserted ");
			System.out.println("Status Code is " + statusCode + " and Test is Passed!!!");
			System.out
					.println("\n=========================================================================================");

		}

		// Sce_05: Search Employee by last Name 
				@Test
				public void search_Employee_By_last_Name() {
					System.out.println("================================== GET REQUEST =========================================");
					System.out.println("Search Employee by Job Title (vp sales)");
					Response resp = given().contentType("application/json").accept(ContentType.JSON).when()
							.get("http://localhost:3000/EmployeeDetails?lastName=Patterson").then().statusCode(200).log().all()
							.extract().response();
					int statusCode = resp.getStatusCode();
					Assert.assertEquals(statusCode, 200);
					System.out.println("Status Code is " + statusCode + " and Test is Passed!!!");
					System.out
							.println("\n=========================================================================================");

				}



}
