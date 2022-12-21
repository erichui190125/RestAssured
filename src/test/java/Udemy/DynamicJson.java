package Udemy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.ReUsableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	@Test(dataProvider = "BooksData")
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all().header("Content-Type", "application/json")
		.body(payload.AddBook(isbn, aisle)).
		when()
		.post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		System.out.println("did i get hit");
		JsonPath js = ReUsableMethods.rawToJson(response);
		System.out.println(js.get("ID"));
		System.out.println();
		
		
		//deletebook
 	}
	
	@DataProvider(name="BooksData")
	public Object[][] getData() {
		return new Object[][] {{"eric1", "1232"}, {"eric2", "1231"}, {"eric3", "1234"}};
	}
	
	

}
