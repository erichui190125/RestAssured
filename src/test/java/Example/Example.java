package Example;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class Example {
	
	
//	@Test
	public void test_get() {
		
		baseURI = "http://localhost:3000";
		
		given().
			param("name", "Automation").
			get("/subjects").
			then().
				statusCode(200).
				log().all();
	}
	
	@Test
	public void test_post() {
		
		JSONObject request = new JSONObject();
		request.put("firstname", "eric");
	
		baseURI = "http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			patch("/users").
		then().
			statusCode(201).
			log().all();
			
	}
	
	@Test
	public void test_patch() {
		
		JSONObject request = new JSONObject();
		
		request.put("lastname", "boguslastname");
	
		baseURI = "http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			patch("/users/3").
		then().
			statusCode(200).
			log().all();
			
	}
	
	@Test
	public void test_put() {
		
		JSONObject request = new JSONObject();
		
		request.put("lastname", "lastname3");
		request.put("subjectId", "4");
		
		baseURI = "http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			patch("/users/4").
		then().
			statusCode(200).
			log().all();
			
	}
	

	
}
