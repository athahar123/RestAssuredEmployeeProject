import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC007_GET_Request_Authorization {

	 @Test
	 void AuthorizationTest()
	 {
	  //Specify base URI
	  RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
	  //basic Authentication
	  PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme();	  
	  authscheme.setUserName("ToolsQA");
	  authscheme.setPassword("TestPassword");
	  RestAssured.authentication=authscheme;
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Response object
	  Response response=httpRequest.request(Method.GET,"/");
	 
	   //print response in console window
	  
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	//status code verification
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is : "+statusCode);
	  Assert.assertEquals(statusCode, 200);
	  
	 }
}