package Udemy;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class Basics {
	
// validate if Add place API is working as expected
	//given - all input details
	//when - Submit the api - resource, http method
	//Then - validate the response
	

	
	@Test
	void test123() {
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").body(payload.AddPlace()).when().post("maps/api/place/add/json")
		//MUST IMPORT HAMCREST FOR THE equalTo method
			.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
			.header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		//Add place -> Update Place with New Address -> Get Place to validate if New address is present in response
		
		JsonPath js = new JsonPath(response); // for parsing Json
		String placeId = js.getString("place_id");
		
		System.out.println(placeId);
		
		//Update Place
		
		given().log().all().queryParam("key" , "qaclick123").body("{\r\n" + 
				"    \"place_id\":\"e740c003f8ca139463f9c211630082dd\",\r\n" + 
				"    \"address\": \"10612 gilbert\",\r\n" + 
				"    \"key\":\"qaclick123\"\r\n" + 
				"}")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().statusCode(200).body("msg",  equalTo("Address successfully updated"));
	}
}
