package Datadriventesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class DataDrivenTest_Add_NewEmployees {
	
	@Test
	
	void postNewEmployees() {
		
		
		//Specify base URI
		  RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/create";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		   
		//Request paylaod sending along with post request
		  JSONObject requestParams=new JSONObject();
		  
		  requestParams.put("name","Jggg");
		  requestParams.put("salary","1155551");
		  requestParams.put("age","40");
		  
		  
		  httpRequest.header("Content-Type","application/json");
		  
		  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
		  
		  //Response object
		  Response response=httpRequest.request(Method.POST,"/create");
		    
		  
		  //success code validation

		  String responseBody=response.getBody().asString();
		  Assert.assertEquals(responseBody.contains("Jggg"), true);	
		  Assert.assertEquals(responseBody.contains("1155551"), true);	
		  Assert.assertEquals(responseBody.contains("40"), true);	

		
		  //status code validation
		  int statusCode=response.getStatusCode();
		  Assert.assertEquals(statusCode, 200);
		  
		
		
		
		
		
	}
	}
