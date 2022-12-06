package DifferentTypes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test01_GET {

	@Test 
	void test_get() {
		
		System.out.println("heil");
		Response response = RestAssured.get("https://reqres.in/api/users?page=2"); 
		
		System.out.println(response.asString());
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		

		given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
		
	}
	

	
}
