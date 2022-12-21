package Udemy;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
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
		String newAddress = "12345 Gilbert";
		
		given().log().all().queryParam("key" , "qaclick123").body("{\r\n" + 
				"    \"place_id\":\""+placeId+"\",\r\n" + 
				"    \"address\": \""+newAddress+"\",\r\n" + 
				"    \"key\":\"qaclick123\"\r\n" + 
				"}")
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg",  equalTo("Address successfully updated"));
		
		//Get Place 
		
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", placeId)
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1 = new JsonPath(getPlaceResponse);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		Assert.assertEquals(actualAddress, newAddress);
	}
	
	
	
		
}
