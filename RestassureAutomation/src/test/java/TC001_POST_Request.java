import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_POST_Request {
	 
	 @Test
	 void getweatherDetails()
	 {
	  //Specify base URI
	  RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Response object
	  Response response=httpRequest.request(Method.GET,"/Hyderabad");
	  
	  //print response in console window
	  
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	  //status code validation
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is : "+statusCode);
	  Assert.assertEquals(statusCode, 200);
	  
	  
	  String statusLine=response.getStatusLine();
	  System.out.println(statusLine);
	  Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	 }
	 

	  
	}




